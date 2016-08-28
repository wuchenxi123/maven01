package com.manage.teacher.persistent;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.core.jop.infrastructure.db.BaseVO;
import com.manage.course.persistent.CourseVO;
import com.manage.gradlass.persistent.GradlassVO;

/** @author Hibernate CodeGenerator */
public class TeacherVO extends BaseVO implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -4103237377829285768L;

	/** identifier field */
    private Integer teId;

    /** nullable persistent field */
    private String teName;

    /** nullable persistent field */
    private Byte teSex;

    /** nullable persistent field */
    private String teAge;
    private String courseName;

    /** nullable persistent field */
    private String teMobile;

    /** nullable persistent field */
    private String teLocation;

    /** nullable persistent field */
    private Double teArrivegradlassrate;

    /** nullable persistent field */
    private Short teGradlasscount;

    /** nullable persistent field */
    private java.util.Date teDatestart;

    /** nullable persistent field */
    private java.util.Date teDataend;

    /** nullable persistent field */
    private java.util.Date updatedate;

    /** nullable persistent field */
    private Integer gradlassteacher;
    
    private List<CourseVO> courseList;
    private List<GradlassVO> gradlassList;

	public TeacherVO(Integer teId, String teName, Byte teSex, String teAge,
			String courseName, String teMobile, String teLocation,
			Double teArrivegradlassrate, Short teGradlasscount,
			Date teDatestart, Date teDataend, Date updatedate,
			Integer gradlassteacher, List<CourseVO> courseList,
			List<GradlassVO> gradlassList) {
		super();
		this.teId = teId;
		this.teName = teName;
		this.teSex = teSex;
		this.teAge = teAge;
		this.courseName = courseName;
		this.teMobile = teMobile;
		this.teLocation = teLocation;
		this.teArrivegradlassrate = teArrivegradlassrate;
		this.teGradlasscount = teGradlasscount;
		this.teDatestart = teDatestart;
		this.teDataend = teDataend;
		this.updatedate = updatedate;
		this.gradlassteacher = gradlassteacher;
		this.courseList = courseList;
		this.gradlassList = gradlassList;
	}

	/** default constructor */
    public TeacherVO() {
    }

    public java.lang.Integer getTeId() {
        return this.teId;
    }

    public void setTeId(java.lang.Integer teId) {
        this.teId = teId;
    }

    public java.lang.String getTeName() {
        return this.teName;
    }

    public void setTeName(java.lang.String teName) {
        this.teName = teName;
    }

    public java.lang.Byte getTeSex() {
        return this.teSex;
    }

    public void setTeSex(java.lang.Byte teSex) {
        this.teSex = teSex;
    }

    public java.lang.String getTeAge() {
        return this.teAge;
    }

    public void setTeAge(java.lang.String teAge) {
        this.teAge = teAge;
    }

    public java.lang.String getTeMobile() {
        return this.teMobile;
    }

    public void setTeMobile(java.lang.String teMobile) {
        this.teMobile = teMobile;
    }

    public java.lang.String getTeLocation() {
        return this.teLocation;
    }

    public void setTeLocation(java.lang.String teLocation) {
        this.teLocation = teLocation;
    }

    public java.lang.Double getTeArrivegradlassrate() {
        return this.teArrivegradlassrate;
    }

    public void setTeArrivegradlassrate(java.lang.Double teArrivegradlassrate) {
        this.teArrivegradlassrate = teArrivegradlassrate;
    }

    public java.lang.Short getTeGradlasscount() {
        return this.teGradlasscount;
    }

    public void setTeGradlasscount(java.lang.Short teGradlasscount) {
        this.teGradlasscount = teGradlasscount;
    }

    public java.util.Date getTeDatestart() {
        return this.teDatestart;
    }

    public void setTeDatestart(java.util.Date teDatestart) {
        this.teDatestart = teDatestart;
    }

    public java.util.Date getTeDataend() {
        return this.teDataend;
    }

    public void setTeDataend(java.util.Date teDataend) {
        this.teDataend = teDataend;
    }

    public java.util.Date getUpdatedate() {
        return this.updatedate;
    }

    public void setUpdatedate(java.util.Date updatedate) {
        this.updatedate = updatedate;
    }

    public java.lang.Integer getGradlassteacher() {
        return this.gradlassteacher;
    }

    public void setGradlassteacher(java.lang.Integer gradlassteacher) {
        this.gradlassteacher = gradlassteacher;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("teId", getTeId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TeacherVO) ) return false;
        TeacherVO castOther = (TeacherVO) other;
        return new EqualsBuilder()
            .append(this.getTeId(), castOther.getTeId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getTeId())
            .toHashCode();
    }

	public List<GradlassVO> getGradlassList() {
		return gradlassList;
	}

	public void setGradlassList(List<GradlassVO> gradlassList) {
		this.gradlassList = gradlassList;
	}

	public List<CourseVO> getCourseList() {
		return courseList;
	}

	public void setCourseList(List<CourseVO> courseList) {
		this.courseList = courseList;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

}
