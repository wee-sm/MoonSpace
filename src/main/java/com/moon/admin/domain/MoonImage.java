package com.moon.admin.domain;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate
public class MoonImage extends MoonAbstractEntity {
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_project_for_image"))
	private MoonProject moonProjects;

	@Lob
	private byte[] image;

	private String imageName;

	public MoonImage() {
		super();
	}

	public MoonImage(MoonProject moonProjects, byte[] image, String imageName) {
		super();
		this.moonProjects = moonProjects;
		this.image = image;
		this.imageName = imageName;
	}

	public MoonProject getMoonProjects() {
		return moonProjects;
	}

	public void setMoonProjects(MoonProject moonProjects) {
		this.moonProjects = moonProjects;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

}
