package rto.dto;

public class PmRequestDTO {
	String application_no,Temp_no,cus_name,chassis_no,tp_allot_date,permanent_no;
	int count;
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getApplication_no() {
		return application_no;
	}

	public void setApplication_no(String application_no) {
		this.application_no = application_no;
	}

	public String getPermanent_no() {
		return permanent_no;
	}

	public void setPermanent_no(String permanent_no) {
		this.permanent_no = permanent_no;
	}

	public String getTemp_no() {
		return Temp_no;
	}

	public void setTemp_no(String temp_no) {
		Temp_no = temp_no;
	}

	public String getCus_name() {
		return cus_name;
	}

	public void setCus_name(String cus_name) {
		this.cus_name = cus_name;
	}

	public String getChassis_no() {
		return chassis_no;
	}

	public void setChassis_no(String chassis_no) {
		this.chassis_no = chassis_no;
	}

	public String getTp_allot_date() {
		return tp_allot_date;
	}

	public void setTp_allot_date(String tp_allot_date) {
		this.tp_allot_date = tp_allot_date;
	}
	

}
