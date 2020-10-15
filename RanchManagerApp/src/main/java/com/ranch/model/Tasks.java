package com.ranch.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import com.ranch.model.enums.TaskType;

@Entity
@Table(name="Task")
public class Tasks {
	@Id @Column(name="task_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long tid;
	
	@Column(name="name", length=40)
	@NotBlank
	private String name;
	
	@Column(name="active")
	@NotBlank
	private boolean active;
	
	@Column(name="avg_time")
	@NotBlank
	private int avgTime;
	
	@Column(name="last_update")
	@NotBlank
	@Temporal(TemporalType.DATE)
	private Date lastUpdate;
	
	@Column(name="task_type")
	@NotBlank
	@Enumerated(EnumType.STRING)
	private TaskType taskType;
	
	@Column(name="description")
	@NotBlank
	private String desc;
	
	@OneToMany
	@JoinTable(name="Completed_Tasks", joinColumns= @JoinColumn(name="task_id"), inverseJoinColumns= @JoinColumn(name="user_id"))
	private List<Users> compTask = new ArrayList<>();
	
	@Column(name="photoUrl")
	private String photoUrl;
	
	// default constructor
	public Tasks() { super(); }

	/**
	 * @param name
	 * @param active
	 * @param avgTime
	 * @param lastUpdate
	 * @param taskType
	 * @param desc
	 * @param compTask
	 * @param photoUrl
	 */
	public Tasks(@NotBlank String name, @NotBlank boolean active, @NotBlank int avgTime, @NotBlank Date lastUpdate,
			@NotBlank TaskType taskType, @NotBlank String desc, List<Users> compTask, String photoUrl) {
		this.name = name;
		this.active = active;
		this.avgTime = avgTime;
		this.lastUpdate = lastUpdate;
		this.taskType = taskType;
		this.desc = desc;
		this.compTask = compTask;
		this.photoUrl = photoUrl;
	}

	/**
	 * @param tid
	 * @param name
	 * @param active
	 * @param avgTime
	 * @param lastUpdate
	 * @param taskType
	 * @param desc
	 * @param compTask
	 * @param photoUrl
	 */
	public Tasks(long tid, @NotBlank String name, @NotBlank boolean active, @NotBlank int avgTime,
			@NotBlank Date lastUpdate, @NotBlank TaskType taskType, @NotBlank String desc, List<Users> compTask,
			String photoUrl) {
		this.tid = tid;
		this.name = name;
		this.active = active;
		this.avgTime = avgTime;
		this.lastUpdate = lastUpdate;
		this.taskType = taskType;
		this.desc = desc;
		this.compTask = compTask;
		this.photoUrl = photoUrl;
	}

	/**
	 * @return the tid
	 */
	public long getTid() {
		return tid;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the active
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * @return the avgTime
	 */
	public int getAvgTime() {
		return avgTime;
	}

	/**
	 * @return the lastUpdate
	 */
	public Date getLastUpdate() {
		return lastUpdate;
	}

	/**
	 * @return the taskType
	 */
	public TaskType getTaskType() {
		return taskType;
	}

	/**
	 * @return the desc
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * @return the compTask
	 */
	public List<Users> getCompTask() {
		return compTask;
	}

	/**
	 * @return the photoUrl
	 */
	public String getPhotoUrl() {
		return photoUrl;
	}

	/**
	 * @param tid the tid to set
	 */
	public void setTid(long tid) {
		this.tid = tid;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

	/**
	 * @param avgTime the avgTime to set
	 */
	public void setAvgTime(int avgTime) {
		this.avgTime = avgTime;
	}

	/**
	 * @param lastUpdate the lastUpdate to set
	 */
	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	/**
	 * @param taskType the taskType to set
	 */
	public void setTaskType(TaskType taskType) {
		this.taskType = taskType;
	}

	/**
	 * @param desc the desc to set
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}

	/**
	 * @param compTask the compTask to set
	 */
	public void setCompTask(List<Users> compTask) {
		this.compTask = compTask;
	}

	/**
	 * @param photoUrl the photoUrl to set
	 */
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
}
