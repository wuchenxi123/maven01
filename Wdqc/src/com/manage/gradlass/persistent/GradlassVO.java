package com.manage.gradlass.persistent;

import com.core.jop.infrastructure.db.BaseVO;
import com.core.jop.infrastructure.db.DataPackage;
import com.manage.campus.persistent.CampusVO;
import com.manage.classroom.persistent.ClassroomVO;
import com.manage.course.persistent.CourseVO;
import com.manage.teacher.persistent.TeacherVO;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class GradlassVO extends BaseVO implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** identifier field */
    private Long csId;

    /** nullable persistent field */
    private Integer coId;
    /** nullable persistent field */
    private Integer coClassify;
    
    /** nullable persistent field */
    private Integer crId;

    /** nullable persistent field */
    private String csName;

    /** nullable persistent field */
    private Integer cpId;

    /** nullable persistent field */
    private Double csCharge;
    
    private Integer csTuition;

    /** nullable persistent field */
    private Integer csClasshour;

    /** nullable persistent field */
    private Short csEveryclass;

    /** nullable persistent field */
    private String csOpendatestart;

    /** nullable persistent field */
    private String csOpendateend;

    /** nullable persistent field */
    private String csOpendatestatus;

    /** nullable persistent field */
    private Integer csClassroomid;

    /** nullable persistent field */
    private String csWeekend;

    /** nullable persistent field */
    private String csDateStartHour;
    
    /** nullable persistent field */
    private String csDateStartMinute;
    
    /** nullable persistent field */
    private String csDateEndHour;
    
    /** nullable persistent field */
    private String csDateEndMinute;

    /** nullable persistent field */
    private Short csPeoplecount;

    private Short csPeopleremain;
    
    /** nullable persistent field */
    private String csArriveinform;

    /** nullable persistent field */
    private String csRemark;

    private String timeFrame;
    
    /** nullable persistent field */
    private java.util.Date createTime;

    /** nullable persistent field */
    private Integer creator;

    /** nullable persistent field */
    private java.util.Date updateTime;

    /** nullable persistent field */
    private Integer updator;
    
    private String cpName;
    
    private String crName;
    
    private String coName;
    
/*    private CourseVO course;
    private ClassroomVO classroom;
    private CampusVO campus;*/
    private TeacherVO teacher;
    private List<TeacherVO> teaList=null;
    public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	private Integer gradlassTeacher; 
    private DataPackage d;
    private String teacherName;
	
	public GradlassVO(Long csId, Integer coId, Integer coClassify,
			Integer crId, String csName, Integer cpId, Double csCharge,
			Integer csTuition, Integer csClasshour, Short csEveryclass,
			String csOpendatestart, String csOpendateend,
			String csOpendatestatus, Integer csClassroomid, String csWeekend,
			String csDateStartHour, String csDateStartMinute,
			String csDateEndHour, String csDateEndMinute, Short csPeoplecount,
			String csArriveinform, String csRemark, String timeFrame,
			CourseVO course, ClassroomVO classroom, CampusVO campus,
			TeacherVO teacher, List<TeacherVO> teaList,
			Integer gradlassTeacher, DataPackage d, String teacherName) {
		super();
		this.csId = csId;
		this.coId = coId;
		this.coClassify = coClassify;
		this.crId = crId;
		this.csName = csName;
		this.cpId = cpId;
		this.csCharge = csCharge;
		this.csTuition = csTuition;
		this.csClasshour = csClasshour;
		this.csEveryclass = csEveryclass;
		this.csOpendatestart = csOpendatestart;
		this.csOpendateend = csOpendateend;
		this.csOpendatestatus = csOpendatestatus;
		this.csClassroomid = csClassroomid;
		this.csWeekend = csWeekend;
		this.csDateStartHour = csDateStartHour;
		this.csDateStartMinute = csDateStartMinute;
		this.csDateEndHour = csDateEndHour;
		this.csDateEndMinute = csDateEndMinute;
		this.csPeoplecount = csPeoplecount;
		this.csArriveinform = csArriveinform;
		this.csRemark = csRemark;
		this.timeFrame = timeFrame;
		this.teacher = teacher;
		this.teaList = teaList;
		this.gradlassTeacher = gradlassTeacher;
		this.d = d;
		this.teacherName = teacherName;
	}

	public String getCsDateStartHour() {
		return csDateStartHour;
	}

	public void setCsDateStartHour(String csDateStartHour) {
		this.csDateStartHour = csDateStartHour;
	}

	public String getCsDateStartMinute() {
		return csDateStartMinute;
	}

	public void setCsDateStartMinute(String csDateStartMinute) {
		this.csDateStartMinute = csDateStartMinute;
	}

	public String getCsDateEndHour() {
		return csDateEndHour;
	}

	public void setCsDateEndHour(String csDateEndHour) {
		this.csDateEndHour = csDateEndHour;
	}

	public String getCsDateEndMinute() {
		return csDateEndMinute;
	}

	public void setCsDateEndMinute(String csDateEndMinute) {
		this.csDateEndMinute = csDateEndMinute;
	}

	/** default constructor */
    public GradlassVO() {
    }

    /** minimal constructor */
    public GradlassVO(java.lang.Long csId) {
        this.csId = csId;
    }

    public java.lang.Long getCsId() {
        return this.csId;
    }

    public void setCsId(java.lang.Long csId) {
        this.csId = csId;
    }

    public java.lang.Integer getCoId() {
        return this.coId;
    }

    public void setCoId(java.lang.Integer coId) {
        this.coId = coId;
    }

    public java.lang.Integer getCrId() {
        return this.crId;
    }

    public void setCrId(java.lang.Integer crId) {
        this.crId = crId;
    }

    public java.lang.String getCsName() {
        return this.csName;
    }

    public void setCsName(java.lang.String csName) {
        this.csName = csName;
    }

    public java.lang.Integer getCpId() {
        return this.cpId;
    }

    public void setCpId(java.lang.Integer cpId) {
        this.cpId = cpId;
    }

    public java.lang.Double getCsCharge() {
        return this.csCharge;
    }

    public void setCsCharge(java.lang.Double csCharge) {
        this.csCharge = csCharge;
    }

    public java.lang.Integer getCsClasshour() {
        return this.csClasshour;
    }

    public void setCsClasshour(java.lang.Integer csClasshour) {
        this.csClasshour = csClasshour;
    }

    public java.lang.Short getCsEveryclass() {
        return this.csEveryclass;
    }

    public void setCsEveryclass(java.lang.Short csEveryclass) {
        this.csEveryclass = csEveryclass;
    }

    public String getCsOpendatestart() {
        return this.csOpendatestart;
    }

    public void setCsOpendatestart(String csOpendatestart) {
        this.csOpendatestart = csOpendatestart;
    }

    public String getCsOpendateend() {
        return this.csOpendateend;
    }

    public void setCsOpendateend(String csOpendateend) {
        this.csOpendateend = csOpendateend;
    }

    public java.lang.String getCsOpendatestatus() {
        return this.csOpendatestatus;
    }

    public void setCsOpendatestatus(java.lang.String csOpendatestatus) {
        this.csOpendatestatus = csOpendatestatus;
    }

    public java.lang.Integer getCsClassroomid() {
        return this.csClassroomid;
    }

    public void setCsClassroomid(java.lang.Integer csClassroomid) {
        this.csClassroomid = csClassroomid;
    }

    public java.lang.String getCsWeekend() {
        return this.csWeekend;
    }

    public void setCsWeekend(java.lang.String csWeekend) {
        this.csWeekend = csWeekend;
    }

    public java.lang.Short getCsPeoplecount() {
        return this.csPeoplecount;
    }

    public void setCsPeoplecount(java.lang.Short csPeoplecount) {
        this.csPeoplecount = csPeoplecount;
    }

    public java.lang.String getCsArriveinform() {
        return this.csArriveinform;
    }

    public void setCsArriveinform(java.lang.String csArriveinform) {
        this.csArriveinform = csArriveinform;
    }

    public java.lang.String getCsRemark() {
        return this.csRemark;
    }

    public void setCsRemark(java.lang.String csRemark) {
        this.csRemark = csRemark;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("csId", getCsId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof GradlassVO) ) return false;
        GradlassVO castOther = (GradlassVO) other;
        return new EqualsBuilder()
            .append(this.getCsId(), castOther.getCsId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCsId())
            .toHashCode();
    }

	public String getTimeFrame() {
		return timeFrame;
	}

	public void setTimeFrame(String timeFrame) {
		this.timeFrame = timeFrame;
	}

	public TeacherVO getTeacher() {
		return teacher;
	}

	public void setTeacher(TeacherVO teacher) {
		this.teacher = teacher;
	}

	public DataPackage getD() {
		return d;
	}

	public void setD(DataPackage d) {
		this.d = d;
	}

	public Integer getGradlassTeacher() {
		return gradlassTeacher;
	}

	public void setGradlassTeacher(Integer gradlassTeacher) {
		this.gradlassTeacher = gradlassTeacher;
	}

	public Integer getCoClassify() {
		return coClassify;
	}

	public void setCoClassify(Integer coClassify) {
		this.coClassify = coClassify;
	}

	public Integer getCsTuition() {
		return csTuition;
	}

	public void setCsTuition(Integer csTuition) {
		this.csTuition = csTuition;
	}

	public List<TeacherVO> getTeaList() {
		return teaList;
	}

	public void setTeaList(List<TeacherVO> teaList) {
		this.teaList = teaList;
	}


	public Integer getCreator() {
		return creator;
	}

	public void setCreator(Integer creator) {
		this.creator = creator;
	}


	public Integer getUpdator() {
		return updator;
	}

	public void setUpdator(Integer updator) {
		this.updator = updator;
	}

	public java.util.Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}

	public java.util.Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(java.util.Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getCpName() {
		return cpName;
	}

	public void setCpName(String cpName) {
		this.cpName = cpName;
	}

	public String getCrName() {
		return crName;
	}

	public void setCrName(String crName) {
		this.crName = crName;
	}

	public String getCoName() {
		return coName;
	}

	public void setCoName(String coName) {
		this.coName = coName;
	}

	public Short getCsPeopleremain() {
		return csPeopleremain;
	}

	public void setCsPeopleremain(Short csPeopleremain) {
		this.csPeopleremain = csPeopleremain;
	}


}
