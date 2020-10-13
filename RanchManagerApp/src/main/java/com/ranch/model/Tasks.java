package com.ranch.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="Task")
@Getter
@Setter
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
	
	@OneToMany
	@JoinTable(name="Completed_Tasks", joinColumns= @JoinColumn(name="task_id"), inverseJoinColumns= @JoinColumn(name="user_id"))
	private Set<Users> compTask = new HashSet<>();

	/**
	 * @param tid
	 * @param name
	 * @param active
	 * @param avgTime
	 * @param taskType
	 * @param compTask
	 */
	public Tasks(long tid, @NotBlank String name, @NotBlank boolean active, @NotBlank int avgTime,
			@NotBlank TaskType taskType, Set<Users> compTask) {
		this.tid = tid;
		this.name = name;
		this.active = active;
		this.avgTime = avgTime;
		this.taskType = taskType;
		this.compTask = compTask;
	}

	/**
	 * @param name
	 * @param active
	 * @param avgTime
	 * @param taskType
	 */
	public Tasks(@NotBlank String name, @NotBlank boolean active, @NotBlank int avgTime, @NotBlank TaskType taskType) {
		this.name = name;
		this.active = active;
		this.avgTime = avgTime;
		this.taskType = taskType;
	}
	
	
}
