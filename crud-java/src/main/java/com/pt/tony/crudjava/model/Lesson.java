package com.pt.tony.crudjava.model;



import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Lesson {

    @Id // diz a JPA que isto é um chave primaria
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    
    private String name;

   
    private String youtubeUrl;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    
    
    /******************************************Construtores*********** */
    
    public Lesson() {
    }

    public Lesson(Long id, String name, String youtubeUrl, Course course) {
        this.id = id;
        this.name = name;
        this.youtubeUrl = youtubeUrl;
        this.course = course;
    }


    /****************************************Getter e Setter*********** */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYoutubeUrl() {
        return youtubeUrl;
    }

    public void setYoutubeUrl(String youtubeUrl) {
        this.youtubeUrl = youtubeUrl;
    }

    // public Course getCourse() {
    //     return course;
    // }

    public void setCourse(Course course) {
        this.course = course;
    }

    /****************************************************************Another methods */

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((youtubeUrl == null) ? 0 : youtubeUrl.hashCode());
        result = prime * result + ((course == null) ? 0 : course.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Lesson other = (Lesson) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (youtubeUrl == null) {
            if (other.youtubeUrl != null)
                return false;
        } else if (!youtubeUrl.equals(other.youtubeUrl))
            return false;
        if (course == null) {
            if (other.course != null)
                return false;
        } else if (!course.equals(other.course))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Lesson [id=" + id + ", name=" + name + ", youtubeUrl=" + youtubeUrl + ", course=" + course + "]";
    }


    
    
    
     

}
