package com.manage.teacher.persistent;

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
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFHeader;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.hibernate.Session;

import com.core.jop.infrastructure.db.AbstractDAO;
import com.core.jop.infrastructure.db.DataPackage;
import com.core.jop.infrastructure.db.hibernate3.Hibernate3SessionManager;
import com.manage.course.persistent.CourseVO;

/**
 * Title: TeacherDAO
 * @author 
 * @version 1.0
 */
public class TeacherDAO extends AbstractDAO {

    /**
     * default constructor
     */
    public TeacherDAO(){
        super(TeacherVO.class);
    }

	public void doGradlassCount(List<String> ids) {
		// TODO Auto-generated method stub
		
	}

	 /**
     * 批量删除多个应用
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
			ds = con.prepareStatement("delete from ms_class_teacher where teacherId = ?");
			dsi = con.prepareStatement("delete from ms_teacher where te_id = ?");
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
		List<TeacherVO> teacherList = new ArrayList<TeacherVO>();// 学生LIst
		if (dp.getRowCount() > 0) {
			for (Object vo : dp.getDatas()) {
				TeacherVO teacher = (TeacherVO) vo;// 学生对象
				teacherList.add(teacher);
			}
		}
		HSSFWorkbook workbook = new HSSFWorkbook(); // 创建一个excel
		HSSFCell cell = null; // Excel的列
		HSSFRow row = null; // Excel的行
		HSSFFont font = workbook.createFont(); // 设置字体
		HSSFSheet sheet = workbook.createSheet("sheet1"); // 创建一个sheet
		HSSFHeader header = sheet.getHeader();// 设置sheet的头
		String[] tableHeader = { "姓名", "性别","年龄", "课程","居住区","手机号","出勤率","带班数","更新时间"};
		short cellNumber = (short) tableHeader.length;// 表的列数
		
		for (int i = 0; i < teacherList.size(); i++) {
			TeacherVO teacher1 = (TeacherVO) teacherList.get(i);// 获取Teacher对象
			row = sheet.createRow((short) (i + 1));// 创建第i+1行
			row.setHeight((short) 400);// 设置行高

			if (teacher1.getTeName() != null) {
				cell = row.createCell(0);// 创建第i+1行第0列
				cell.setCellValue(teacher1.getTeName());// 设置第i+1行第0列的值	
			}
			if (teacher1.getTeSex() != null) {
				cell = row.createCell(1); // 创建第i+1行第1列
				cell.setCellValue(teacher1.getTeSex()==1?"女":"男");// 设置第i+1行第1列的值
			}
			// 由于下面的和上面的基本相同，就不加注释了
			if (teacher1.getTeAge() != null) {
				cell = row.createCell(2);
				cell.setCellValue(teacher1.getTeAge());
			}
			if (teacher1.getCourseList() != null) {
				cell = row.createCell(3);
				String str="";
				for (CourseVO cou : teacher1.getCourseList()) {
					str+=cou.getCoName()+"|";
				}
				cell.setCellValue(str);
			}
			if (teacher1.getTeLocation() != null) {
				cell = row.createCell(4);
				cell.setCellValue(teacher1.getTeLocation());
			}
			if (teacher1.getTeMobile() != null) {
				cell = row.createCell(5);
				cell.setCellValue(teacher1.getTeMobile());
			}
			if (teacher1.getTeArrivegradlassrate() != null) {
				cell = row.createCell(6);
				cell.setCellValue(teacher1.getTeArrivegradlassrate());
			}
			if (teacher1.getTeGradlasscount() != null) {
				cell = row.createCell(7);
				cell.setCellValue(teacher1.getTeGradlasscount());
			}
			if (teacher1.getUpdatedate() != null) {
				cell = row.createCell(8);
				SimpleDateFormat d=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String updatestring=d.format(teacher1.getUpdatedate());
				cell.setCellValue(updatestring);
			}
		}

		try {
			if (teacherList.size() < 1) {
				header.setCenter("查无资料");
			} else {
				header.setCenter("教师名单");
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
		Date date=new Date();
		SimpleDateFormat d=new SimpleDateFormat("yyyyMMddHHmmss");
		String datestring=d.format(date);
		String filename="教师名单"+datestring;
		System.out.println(filename);
		String path="C:/Users/Administrator/Desktop/Chart/"+filename+".xls";
		try {
			out = new FileOutputStream(
					new File(path));
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
		return null;
	}
}
