package com.manage.extra;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFHeader;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts2.ServletActionContext;

import com.core.jop.infrastructure.control.BOFactory;
import com.core.jop.infrastructure.db.DAOFactory;
import com.core.jop.infrastructure.db.DataPackage;
import com.core.jop.ui.struts2.BaseAction;
import com.manage.student.control.Student;
import com.manage.student.control.StudentBO;
import com.manage.student.persistent.StudentDAO;
import com.manage.student.persistent.StudentVO;
import com.manage.student.web.StudentWebParam;

public class ExportAction extends BaseAction {
	private static final String NET_STATUS = null;
	private static final String NET_MODEL_NUMBER = null;
	private static final String NET_BUILDING = null;
	private static final String NET_FLOOR = null;
	private static final String NET_LOCATION = null;
	private InputStream inputStream; //（get,set方法省略）定义一个输入流，用于接住在Service类生成的含有EXCEL的输入流

	public String exportNetworkDeviceList() throws Exception {
	    setInputStream(exportNetworkDeviceList(NET_STATUS, NET_MODEL_NUMBER, NET_BUILDING, NET_FLOOR, NET_LOCATION)); 
	        return "getNetworkDeviceExportList";
	    }
	
	private void setInputStream(InputStream exportNetworkDeviceList) {
		// TODO Auto-generated method stub
		
	}

	public InputStream exportNetworkDeviceList(String netStatus,
            String netModelNumber, String netBuilding, String netFloor,
            String netLocation) throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		StudentWebParam params = (StudentWebParam) this.getParam();
		Student bo = (Student) BOFactory.build(StudentBO.class,
				this.getDBAccessUser());
		DataPackage dp = bo.doQuery(params);
		List<StudentVO> studentList = new ArrayList<StudentVO>();// 学生LIst
		if (dp.getRowCount() > 0) {
			for (Object vo : dp.getDatas()) {
				StudentVO student = (StudentVO) vo;// 学生对象
				studentList.add(student);
			}
		}
		HSSFWorkbook workbook = new HSSFWorkbook(); // 创建一个excel
		HSSFCell cell = null; // Excel的列
		HSSFRow row = null; // Excel的行
		HSSFFont font = workbook.createFont(); // 设置字体
		HSSFSheet sheet = workbook.createSheet("sheet1"); // 创建一个sheet
		HSSFHeader header = sheet.getHeader();// 设置sheet的头
		String[] tableHeader = { "学号", "姓名", "性别", "电话", "家长电话", "email",
				"居住地", "销售人", "经办人" };
		short cellNumber = (short) tableHeader.length;// 表的列数
		HSSFCellStyle style = workbook.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		for (int i = 0; i < studentList.size(); i++) {
			StudentVO student1 = (StudentVO) studentList.get(i);// 获取student对象
			row = sheet.createRow((short) (i + 1));// 创建第i+1行
			row.setHeight((short) 400);// 设置行高

			if (student1.getStId() != null) {
				cell = row.createCell(0);// 创建第i+1行第0列
				cell.setCellValue(student1.getStId());// 设置第i+1行第0列的值
			}
			if (student1.getStName() != null) {
				cell = row.createCell(1); // 创建第i+1行第1列
				cell.setCellValue(student1.getStName());// 设置第i+1行第1列的值
			}
			// 由于下面的和上面的基本相同，就不加注释了
			if (student1.getStSex() != null) {
				cell = row.createCell(2);
				cell.setCellValue(student1.getStSex());
			}
			if (student1.getStMobile() != null) {
				cell = row.createCell(3);
				cell.setCellValue(student1.getStMobile());
			}
			if (student1.getStMotherMobile() != null) {
				cell = row.createCell(4);
				cell.setCellValue(student1.getStMotherMobile());
			}
			if (student1.getStEmail() != null) {
				cell = row.createCell(5);
				cell.setCellValue(student1.getStEmail());
			}
			if (student1.getStReside() != null) {
				cell = row.createCell(6);
				cell.setCellValue(student1.getStReside());
			}
			if (student1.getSalerName() != null) {
				cell = row.createCell(7);
				cell.setCellValue(student1.getSalerName());
			}
			if (student1.getCreatorname() != null) {
				cell = row.createCell(8);
				cell.setCellValue(student1.getCreatorname());
			}
		}

		try {
			if (studentList.size() < 1) {
				header.setCenter("查无资料");
			} else {
				header.setCenter("学生表");
				row = sheet.createRow(0);
				row.setHeight((short) 400);
				for (int k = 0; k < cellNumber; k++) {
					cell = row.createCell(k);// 创建第0行第k列
					cell.setCellValue(tableHeader[k]);// 设置第0行第k列的值
					sheet.setColumnWidth(k, 8000);// 设置列的宽度
					font.setColor(HSSFFont.COLOR_NORMAL); // 设置单元格字体的颜色.
					font.setFontHeight((short) 350); // 设置单元字体高度
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

 


  //设置文件名，用格式化日期来生成一个ID
        String filePath="";
        Date dt = new Date();
        DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        String date = df.format(dt).toString();
        filePath = "NetDevice" + date + ".xls";
        File file=new File(filePath);
        try{
            OutputStream out=new FileOutputStream(file);
            workbook.write(out);
            out.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        InputStream in=null;
        try{
            in=new FileInputStream(file);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return in;
    }
}
