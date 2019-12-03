/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.priv_form.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author simon
 */
@Entity
@Table(name = "course")
@NamedQueries({
    @NamedQuery(name = "Course.findAll", query = "SELECT c FROM Course c"),
    @NamedQuery(name = "Course.findByCode", query = "SELECT c FROM Course c WHERE c.code = :code"),
    @NamedQuery(name = "Course.findByTitle", query = "SELECT c FROM Course c WHERE c.title = :title")})
public class Course implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "courseCode")
    private Collection<CourseSession> courseSessionCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "code")
    private String code;
    @Basic(optional = false)
    @Column(name = "title")
    private String title;

    public Course() {
    }

    public Course(String code) {
        this.code = code;
    }

    public Course(String code, String title) {
        this.code = code;
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (code != null ? code.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Course)) {
            return false;
        }
        Course other = (Course) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.utbm.priv_form.entity.Course[ code=" + code + " ]";
    }

    public Collection<CourseSession> getCourseSessionCollection() {
        return courseSessionCollection;
    }

    public void setCourseSessionCollection(Collection<CourseSession> courseSessionCollection) {
        this.courseSessionCollection = courseSessionCollection;
    }
    
}
