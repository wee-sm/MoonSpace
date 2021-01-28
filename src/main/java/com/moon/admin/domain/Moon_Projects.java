package com.moon.admin.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate
public class Moon_Projects {
	@Column(nullable = false, unique = true)
	private Long pno;

	@Column(nullable = false)
	private String projectName;

	@OneToMany(mappedBy = "moonProjects", cascade = CascadeType.ALL)
	@OrderBy("imageName ASC")
	private List<Moon_Images> moonImages;

	public Moon_Projects() {
		super();
	}

	public Moon_Projects(Long pno, String projectName, List<Moon_Images> moonImages) {
		super();
		this.pno = pno;
		this.projectName = projectName;
		this.moonImages = moonImages;
	}

	public Long getPno() {
		return pno;
	}

	public void setPno(Long pno) {
		this.pno = pno;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public List<Moon_Images> getMoonImages() {
		return moonImages;
	}

	public void setMoonImages(List<Moon_Images> moonImages) {
		this.moonImages = moonImages;
	}

}
