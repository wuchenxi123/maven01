package com.manage.gradlass.persistent;

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
import com.manage.teacher.persistent.TeacherVO;

/**
 * Title: GradlassDAO
 * @author Hujj
 * @version 1.0
 */
public class GradlassDAO extends AbstractDAO {

    /**
     * default constructor
     */
    public GradlassDAO(){
        super(GradlassVO.class);
    }
    
    /**
     * 批量添加多个应用
     * @param list
     * @throws SQLException
     */
    /*
    public GradlassVO doCreate(GradlassVO vo,DBAccessUser user) throws SQLException {
    	Hibernate3SessionManager sm = (Hibernate3SessionManager) this
				.getSessionManager();
		Connection con = ((Session) sm.getCurrentSession()).connection();
		con.setAutoCommit(false);
		sm.setSessionFactory((SessionFactory) con);
		GradlassDAO dao = (GradlassDAO) DAOFactory.build(GradlassDAO.class,
				user);
		GradlassTeacherDAO gtdao = (GradlassTeacherDAO) DAOFactory.build(GradlassTeacherDAO.class,
				user);
		dao.setSessionManager(sm);
		
		gtdao.setSessionManager(sm);
		PreparedStatement ds = null;
		PreparedStatement dsi = null;
		try {
			GradlassVO gvo=(GradlassVO) dao.create(vo);
			ds = con.prepareStatement("insert into ms_gradlass " +
					"(co_id,co_classify,cr_id,cs_name,cp_id,gradlassTeacher," +
					"cs_charge,cs_classHour,cs_everyClass,cs_openDateStart,cs_openDateEnd," +
					"cs_openDateStatus,cs_classroomId,cs_weekend,cs_dateStartHour," +
					"cs_dateStartMinute,cs_dateEndHour ,cs_dateEndMinute,cs_peopleCount," +
					"cs_arriveInform,cs_remark,cs_tuition) " +
					"values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"); 
			for (int i = 1; i <= 22; i++) {
				ds.setInt(i, vo.getCoId());
				ds.setInt(i, vo.getCoClassify());
				ds.setInt(i, vo.getCrId());
				ds.setString(i, vo.getCsName());
				ds.setInt(i, vo.getCpId());
				ds.setInt(i, vo.getGradlassTeacher());
				ds.setDouble(i, vo.get);
			}
			List<TeacherVO> teaAll=vo.getTeaList();
			if(teaAll.size()>0&&teaAll!=null){
				for (TeacherVO teacherVO : teaAll) {
					GradlassTeacherVO gto=new GradlassTeacherVO();
					gto.setGradlassid(vo.getCsId().intValue());
					gto.setTeacherid(teacherVO.getTeId().intValue());
					gtdao.create(gto);
				}
			}
			boolean ac = con.getAutoCommit();
			if (ac) {
				con.setAutoCommit(false);
			}
			int a=3;
			 int b=0;
			 
				int c=a/b;
				System.out.println(c);
			con.commit();
			con.setAutoCommit(ac);
			return gvo;
		} catch (Exception e) {
			e.printStackTrace();
			con.rollback();
			return null;
		} finally {
//			if (null != ds) {
//				ds.close();
//			}
		}
		
    }
    */
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
			ds = con.prepareStatement("delete from ms_class_teacher where gradlassId = ?");
			dsi = con.prepareStatement("delete from ms_gradlass where cs_id = ?");
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
			ds.executeBatch();
			dsi.executeBatch();
			con.commit();
			con.setAutoCommit(ac);
		} catch (Exception e) {
			e.printStackTrace();
			con.rollback();
		} finally {
			if (null != ds) {
				ds.close();
			}
			if (null != dsi) {
				dsi.close();
			}
		}
    }
    
    public String extport(DataPackage dp) throws Exception {
		List<GradlassVO> gradlassList = new ArrayList<GradlassVO>();// 班级LIst
		if (dp.getRowCount() > 0) {
			for (Object vo : dp.getDatas()) {
				GradlassVO Gradlass = (GradlassVO) vo;// 班级对象
				gradlassList.add(Gradlass);
			}
		}
		HSSFWorkbook workbook = new HSSFWorkbook(); // 创建一个excel
		HSSFCell cell = null; // Excel的列
		HSSFRow row = null; // Excel的行
		HSSFFont font = workbook.createFont(); // 设置字体
		HSSFSheet sheet = workbook.createSheet("sheet1"); // 创建一个sheet
		HSSFHeader header = sheet.getHeader();// 设置sheet的头
		String[] tableHeader = {  "班名", "人数","教师", "课程","开班","星期",
				"时段","校区","教室","学费","状态","更新时间"};
		short cellNumber = (short) tableHeader.length;// 表的列数
		
		for (int i = 0; i < gradlassList.size(); i++) {
			GradlassVO grad = (GradlassVO) gradlassList.get(i);// 获取student对象
			row = sheet.createRow((short) (i + 1));// 创建第i+1行
			row.setHeight((short) 400);// 设置行高

			if (grad.getCsName() != null) {
				cell = row.createCell(0);// 创建第i+1行第0列
				cell.setCellValue(grad.getCsName());// 设置第i+1行第0列的值	
			}
			if (grad.getCsPeoplecount()!=null) {
				cell = row.createCell(1); // 创建第i+1行第1列
				cell.setCellValue(grad.getCsPeoplecount());// 设置第i+1行第1列的值
			}
			// 由于下面的和上面的基本相同，就不加注释了
			if (grad.getTeaList() != null&&grad.getTeaList().size()>0) {
				cell = row.createCell(2);
				String teas="";
				for (TeacherVO te : grad.getTeaList()) {
					teas+=te.getTeName()+"|";
				}
				cell.setCellValue(teas);
			}
			if (grad.getCoName() != null) {
				cell = row.createCell(3);
				cell.setCellValue(grad.getCoName());
			}
			if (grad.getCsOpendatestart() != null) {
				cell = row.createCell(4);
				cell.setCellValue(grad.getCsOpendatestart());
			}
			if (grad.getCsWeekend() != null) {
				cell = row.createCell(5);
				cell.setCellValue(grad.getCsWeekend());
			}
			if (grad.getTimeFrame() != null) {
				cell = row.createCell(6);
				cell.setCellValue(grad.getTimeFrame());
			}
			if (grad.getCpName() != null) {
				cell = row.createCell(7);
				cell.setCellValue(grad.getCpName());
			}
			if (grad.getCrName() != null) {
				cell = row.createCell(8);
				cell.setCellValue(grad.getCrName());
			}
			if (grad.getCsCharge() != null) {
				cell = row.createCell(9);
				cell.setCellValue(grad.getCsCharge());
			}
			if (grad.getCsStatus() != null) {
				cell = row.createCell(10);
				cell.setCellValue(grad.getCsStatus()==0?"开班":"下线");
			}
			if (grad.getUpdateTime() != null) {
				cell = row.createCell(11);
				SimpleDateFormat d=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String updatestring=d.format(grad.getUpdateTime());
				cell.setCellValue(updatestring);
			}
		}

		try {
			if (gradlassList.size() < 1) {
				header.setCenter("查无资料");
			} else {
				header.setCenter("班级列表");
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
		String filename="班级列表"+datestring;
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
