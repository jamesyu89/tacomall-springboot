DROP TABLE IF EXISTS qrtz_fired_triggers;
DROP TABLE IF EXISTS qrtz_paused_trigger_grps;
DROP TABLE IF EXISTS qrtz_scheduler_state;
DROP TABLE IF EXISTS qrtz_locks;
DROP TABLE IF EXISTS qrtz_simple_triggers;
DROP TABLE IF EXISTS qrtz_simprop_triggers;
DROP TABLE IF EXISTS qrtz_cron_triggers;
DROP TABLE IF EXISTS qrtz_blob_triggers;
DROP TABLE IF EXISTS qrtz_triggers;
DROP TABLE IF EXISTS qrtz_job_details;
DROP TABLE IF EXISTS qrtz_calendars;



#-- 存储每一个已配置的 Job 的详细信息
CREATE TABLE qrtz_job_details(
	sched_name VARCHAR(120) NOT NULL,
	job_name VARCHAR(200) NOT NULL,
	job_group VARCHAR(200) NOT NULL,
	description VARCHAR(250) NULL,
	job_class_name VARCHAR(250) NOT NULL,
	is_durable VARCHAR(1) NOT NULL,
	is_nonconcurrent VARCHAR(1) NOT NULL,
	is_update_data VARCHAR(1) NOT NULL,
	requests_recovery VARCHAR(1) NOT NULL,
	job_data BLOB NULL,
	PRIMARY KEY (sched_name,job_name,job_group)
)  ENGINE=InnoDB DEFAULT CHARSET=utf8 ;


#--存储已配置的 Trigger 的信息
CREATE TABLE qrtz_triggers (
	sched_name VARCHAR(120) NOT NULL,
	trigger_name VARCHAR(200) NOT NULL,
	trigger_group VARCHAR(200) NOT NULL,
	job_name VARCHAR(200) NOT NULL,
	job_group VARCHAR(200) NOT NULL,
	description VARCHAR(250) NULL,
	next_fire_time BIGINT(13) NULL,
	prev_fire_time BIGINT(13) NULL,
	priority INTEGER NULL,
	trigger_state VARCHAR(16) NOT NULL,
	trigger_type VARCHAR(8) NOT NULL,
	start_time BIGINT(13) NOT NULL,
	end_time BIGINT(13) NULL,
	calendar_name VARCHAR(200) NULL,
	misfire_instr SMALLINT(2) NULL,
	job_data BLOB NULL,
	PRIMARY KEY (sched_name,trigger_name,trigger_group),
	FOREIGN KEY (sched_name,job_name,job_group)
	REFERENCES qrtz_job_details(sched_name,job_name,job_group)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ;


#-- 存储简单的 Trigger，包括重复次数，间隔，以及已触的次数
CREATE TABLE qrtz_simple_triggers (
	sched_name VARCHAR(120) NOT NULL,
	trigger_name VARCHAR(200) NOT NULL,
	trigger_group VARCHAR(200) NOT NULL,
	repeat_count BIGINT(7) NOT NULL,
	repeat_interval BIGINT(12) NOT NULL,
	times_triggered BIGINT(10) NOT NULL,
	PRIMARY KEY (sched_name,trigger_name,trigger_group),
	FOREIGN KEY (sched_name,trigger_name,trigger_group)
	REFERENCES qrtz_triggers(sched_name,trigger_name,trigger_group)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ;


#-- 存储 Cron Trigger，包括 Cron 表达式和时区信息
CREATE TABLE qrtz_cron_triggers (
	sched_name VARCHAR(120) NOT NULL,
	trigger_name VARCHAR(200) NOT NULL,
	trigger_group VARCHAR(200) NOT NULL,
	cron_expression VARCHAR(120) NOT NULL,
	time_zone_id VARCHAR(80),
	PRIMARY KEY (sched_name,trigger_name,trigger_group),
	FOREIGN KEY (sched_name,trigger_name,trigger_group)
	REFERENCES qrtz_triggers(sched_name,trigger_name,trigger_group)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ;


#-- 存储简单的 Trigger，包括重复次数，间隔，以及已触的次数
CREATE TABLE qrtz_simprop_triggers (
    sched_name VARCHAR(120) NOT NULL,
    trigger_name VARCHAR(200) NOT NULL,
    trigger_group VARCHAR(200) NOT NULL,
    str_prop_1 VARCHAR(512) NULL,
    str_prop_2 VARCHAR(512) NULL,
    str_prop_3 VARCHAR(512) NULL,
    int_prop_1 INT NULL,
    int_prop_2 INT NULL,
    long_prop_1 BIGINT NULL,
    long_prop_2 BIGINT NULL,
    dec_prop_1 NUMERIC(13,4) NULL,
    dec_prop_2 NUMERIC(13,4) NULL,
    bool_prop_1 VARCHAR(1) NULL,
    bool_prop_2 VARCHAR(1) NULL,
    PRIMARY KEY (sched_name,trigger_name,trigger_group),
    FOREIGN KEY (sched_name,trigger_name,trigger_group)
    REFERENCES qrtz_triggers(sched_name,trigger_name,trigger_group)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ;

#-- Trigger 作为 Blob 类型存储
#-- (用于 Quartz 用户用 JDBC 创建他们自己定制的 Trigger 类型，JobStore并不知道如何存储实例的时候)
CREATE TABLE qrtz_blob_triggers (
    sched_name VARCHAR(120) NOT NULL,
    trigger_name VARCHAR(200) NOT NULL,
    trigger_group VARCHAR(200) NOT NULL,
    blob_data BLOB NULL,
    PRIMARY KEY (sched_name,trigger_name,trigger_group),
    INDEX (sched_name,trigger_name, trigger_group),
    FOREIGN KEY (sched_name,trigger_name,trigger_group)
    REFERENCES qrtz_triggers(sched_name,trigger_name,trigger_group)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ;


#-- 以 Blob 类型存储 Quartz 的 Calendar 信息
CREATE TABLE qrtz_calendars (
    sched_name VARCHAR(120) NOT NULL,
    calendar_name VARCHAR(200) NOT NULL,
    calendar BLOB NOT NULL,
    PRIMARY KEY (sched_name,calendar_name)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 ;

#-- 存储已暂停的 Trigger 组的信息
CREATE TABLE qrtz_paused_trigger_grps (
    sched_name VARCHAR(120) NOT NULL,
    trigger_group VARCHAR(200) NOT NULL,
    PRIMARY KEY (sched_name,trigger_group)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 ;


#-- 存储与已触发的 Trigger 相关的状态信息，以及相联 Job 的执行信息
CREATE TABLE qrtz_fired_triggers (
    sched_name VARCHAR(120) NOT NULL,
    entry_id VARCHAR(95) NOT NULL,
    trigger_name VARCHAR(200) NOT NULL,
    trigger_group VARCHAR(200) NOT NULL,
    instance_name VARCHAR(200) NOT NULL,
    fired_time BIGINT(13) NOT NULL,
    sched_time BIGINT(13) NOT NULL,
    priority INTEGER NOT NULL,
    state VARCHAR(16) NOT NULL,
    job_name VARCHAR(200) NULL,
    job_group VARCHAR(200) NULL,
    is_nonconcurrent VARCHAR(1) NULL,
    requests_recovery VARCHAR(1) NULL,
    PRIMARY KEY (sched_name,entry_id)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 ;


#-- 存储少量的有关 Scheduler 的状态信息，和别的 Scheduler 实例(假如是用于一个集群中)
CREATE TABLE qrtz_scheduler_state (
    sched_name VARCHAR(120) NOT NULL,
    instance_name VARCHAR(200) NOT NULL,
    last_checkin_time BIGINT(13) NOT NULL,
    checkin_interval BIGINT(13) NOT NULL,
    PRIMARY KEY (sched_name,instance_name)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 ;


#-- 存储程序的悲观锁的信息(假如使用了悲观锁)
CREATE TABLE qrtz_locks (
    sched_name VARCHAR(120) NOT NULL,
    lock_name VARCHAR(40) NOT NULL,
    PRIMARY KEY (sched_name,lock_name)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ;



CREATE INDEX idx_qrtz_j_req_recovery ON qrtz_job_details(sched_name,requests_recovery);
CREATE INDEX idx_qrtz_j_grp ON qrtz_job_details(sched_name,job_group);

CREATE INDEX idx_qrtz_t_j ON qrtz_triggers(sched_name,job_name,job_group);
CREATE INDEX idx_qrtz_t_jg ON qrtz_triggers(sched_name,job_group);
CREATE INDEX idx_qrtz_t_c ON qrtz_triggers(sched_name,calendar_name);
CREATE INDEX idx_qrtz_t_g ON qrtz_triggers(sched_name,trigger_group);
CREATE INDEX idx_qrtz_t_state ON qrtz_triggers(sched_name,trigger_state);
CREATE INDEX idx_qrtz_t_n_state ON qrtz_triggers(sched_name,trigger_name,trigger_group,trigger_state);
CREATE INDEX idx_qrtz_t_n_g_state ON qrtz_triggers(sched_name,trigger_group,trigger_state);
CREATE INDEX idx_qrtz_t_next_fire_time ON qrtz_triggers(sched_name,next_fire_time);
CREATE INDEX idx_qrtz_t_nft_st ON qrtz_triggers(sched_name,trigger_state,next_fire_time);
CREATE INDEX idx_qrtz_t_nft_misfire ON qrtz_triggers(sched_name,misfire_instr,next_fire_time);
CREATE INDEX idx_qrtz_t_nft_st_misfire ON qrtz_triggers(sched_name,misfire_instr,next_fire_time,trigger_state);
CREATE INDEX idx_qrtz_t_nft_st_misfire_grp ON qrtz_triggers(sched_name,misfire_instr,next_fire_time,trigger_group,trigger_state);

CREATE INDEX idx_qrtz_ft_trig_inst_name ON qrtz_fired_triggers(sched_name,instance_name);
CREATE INDEX idx_qrtz_ft_inst_job_req_rcvry ON qrtz_fired_triggers(sched_name,instance_name,requests_recovery);
CREATE INDEX idx_qrtz_ft_j_g ON qrtz_fired_triggers(sched_name,job_name,job_group);
CREATE INDEX idx_qrtz_ft_jg ON qrtz_fired_triggers(sched_name,job_group);
CREATE INDEX idx_qrtz_ft_t_g ON qrtz_fired_triggers(sched_name,trigger_name,trigger_group);
CREATE INDEX idx_qrtz_ft_tg ON qrtz_fired_triggers(sched_name,trigger_group);

commit;