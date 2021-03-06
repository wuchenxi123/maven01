package com.manage.student.persistent;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFHeader;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.hibernate.Session;

import com.core.jop.infrastructure.db.AbstractDAO;
import com.core.jop.infrastructure.db.DataPackage;
import com.core.jop.infrastructure.db.hibernate3.Hibernate3SessionManager;

/**
 * Title: StudentDAO
 * 
 * @author Hujj
 * @version 1.0
 */
public class StudentDAO extends AbstractDAO {

	/**
	 * default constructor
	 */
	public StudentDAO() {
		super(StudentVO.class);
	}

	/**
	 * 批量删除多个应用
	 * 
	 * @param list
	 * @throws SQLException
	 */
	public void doDel(List<String> list) throws SQLException {
		Hibernate3SessionManager sm = (Hibernate3SessionManager) this
				.getSessionManager();
		Connection con = ((Session) sm.getCurrentSession()).connection();
		PreparedStatement ds = null;
		PreparedStatement dsi = null;
		try {
			ds = con.prepareStatement("delete from ms_student where st_id = ?");
			dsi = con
					.prepareStatement("delete from ms_studentclass where st_id = ?");
			for (int i = 0; i < list.size(); i++) {
				Integer sbId = Integer.valueOf(list.get(i).trim());
				ds.setInt(1, sbId);
				ds.addBatch();

				dsi.setInt(1, sbId);
				dsi.addBatch();
			}

			boolean ac = con.getAutoCommit();
			if (ac) {
				con.setAutoCommit(false);
			}
			dsi.executeBatch();
			ds.executeBatch();
			con.commit();
			con.setAutoCommit(ac);
		} catch (Exception e) {
			e.printStackTrace();
			con.rollback();
		} finally {
			if (null != ds) {
				ds.close();
			}
		}
	}

	public String extport(DataPackage dp) throws Exception {
		List<StudentVO> studentList = new ArrayList<StudentVO>();// 学生LIst
		if (dp.getRowCount() > 0) {
			for (Object vo : dp.getDatas()) {
				StudentVO student = (StudentVO) vo;// 学生对象
				studentList.add(student);
			}
		}
		@SuppressWarnings("resource")
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

		// HttpServletResponse response = null;//创建一个HttpServletResponse对象
		OutputStream out = null;
		Date date = new Date();
		SimpleDateFormat d = new SimpleDateFormat("yyyyMMddHHmmss");
		String datestring = d.format(date);
		String filename = "学生报名表" + datestring;
		String filePath = "C:/Users/USER/Desktop/" + filename + ".xls";
		System.out.println(filePath);
		try {
			out = new FileOutputStream(new File(filePath));
			// response =
			// ServletActionContext.getResponse();//初始化HttpServletResponse对象
			// out = response.getOutputStream();//
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			workbook.write(out);
			out.flush();
			workbook.write(out);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (out != null) {
					out.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return filePath;
	}
}
