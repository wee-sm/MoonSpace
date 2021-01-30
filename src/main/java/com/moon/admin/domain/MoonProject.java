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
public class MoonProject extends MoonAbstractEntity {
	@Column(nullable = false, unique = true)
	private Long pno;

	@Column(nullable = false)
	private String projectName;

	@OneToMany(mappedBy = "moonProjects", cascade = CascadeType.ALL)
	@OrderBy("imageName ASC")
	private List<MoonImage> moonImages;

	public MoonProject() {
		super();
	}

	public MoonProject(String projectName) {
		super();
		this.projectName = projectName;
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

	public List<MoonImage> getMoonImages() {
		return moonImages;
	}

	public void setMoonImages(List<MoonImage> moonImages) {
		this.moonImages = moonImages;
	}

	public void update(MoonProject updatemoonproject) {
		this.pno = updatemoonproject.getPno();
		this.projectName = updatemoonproject.getProjectName();
	}
}
