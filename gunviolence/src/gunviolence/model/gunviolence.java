package gunviolence.model;

import java.math.BigDecimal;
import java.util.Date;

public class gunviolence {
private int incident_id;//�¼����
private Date date;//��������
private String state;//������״
private String city_or_county;//����/����Ĺ���
private String address;//����ص�ĵ�ַ
private int n_killed;//��������
private int n_injured;//��������ַ
private String gun_stolen;//�漰�����ǹ֧״��
private String gun_type;//�ڷ�����ʹ�õ�ǹ������
private String incident_characteristics;//��������
private BigDecimal  latitude; //γ��
private String location_description;//��ַ����
private BigDecimal  longitude; //����
private int n_guns_involved;//�¼��漰��ǹ֧����
private String notes;//�йط����������Ϣ
private int participant_age;//����ʱ�����ߵ�����
private String participant_age_group;//��ʱ����������������
private String participant_gender;//�����ߵ��Ա�
private String participant_name;//���뷸��Ĳ���������
private String participant_relationship;//�����������������ߵĹ�ϵ
private String participant_status;//�Բ���������˺��ĳ̶�
private String participant_type;//�����ߵ�����
private int injuredandkilled;

public int getInjuredandkilled() {
	return injuredandkilled;
}
public void setInjuredandkilled(int injuredandkilled) {
	this.injuredandkilled = injuredandkilled;
}
public int getIncident_id() {
	return incident_id;
}
public void setIncident_id(int incident_id) {
	this.incident_id = incident_id;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public String getCity_or_county() {
	return city_or_county;
}
public void setCity_or_county(String city_or_county) {
	this.city_or_county = city_or_county;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public int getN_killed() {
	return n_killed;
}
public void setN_killed(int n_killed) {
	this.n_killed = n_killed;
}
public int getN_injured() {
	return n_injured;
}
public void setN_injured(int n_injured) {
	this.n_injured = n_injured;
}
public String getGun_stolen() {
	return gun_stolen;
}
public void setGun_stolen(String gun_stolen) {
	this.gun_stolen = gun_stolen;
}
public String getGun_type() {
	return gun_type;
}
public void setGun_type(String gun_type) {
	this.gun_type = gun_type;
}
public String getIncident_characteristics() {
	return incident_characteristics;
}
public void setIncident_characteristics(String incident_characteristics) {
	this.incident_characteristics = incident_characteristics;
}
public BigDecimal getLatitude() {
	return latitude;
}
public void setLatitude(BigDecimal latitude) {
	this.latitude = latitude;
}
public String getLocation_description() {
	return location_description;
}
public void setLocation_description(String location_description) {
	this.location_description = location_description;
}
public BigDecimal getLongitude() {
	return longitude;
}
public void setLongitude(BigDecimal longitude) {
	this.longitude = longitude;
}
public int getN_guns_involved() {
	return n_guns_involved;
}
public void setN_guns_involved(int n_guns_involved) {
	this.n_guns_involved = n_guns_involved;
}
public String getNotes() {
	return notes;
}
public void setNotes(String notes) {
	this.notes = notes;
}
public int getParticipant_age() {
	return participant_age;
}
public void setParticipant_age(int participant_age) {
	this.participant_age = participant_age;
}
public String getParticipant_age_group() {
	return participant_age_group;
}
public void setParticipant_age_group(String participant_age_group) {
	this.participant_age_group = participant_age_group;
}
public String getParticipant_gender() {
	return participant_gender;
}
public void setParticipant_gender(String participant_gender) {
	this.participant_gender = participant_gender;
}
public String getParticipant_name() {
	return participant_name;
}
public void setParticipant_name(String participant_name) {
	this.participant_name = participant_name;
}
public String getParticipant_relationship() {
	return participant_relationship;
}
public void setParticipant_relationship(String participant_relationship) {
	this.participant_relationship = participant_relationship;
}
public String getParticipant_status() {
	return participant_status;
}
public void setParticipant_status(String participant_status) {
	this.participant_status = participant_status;
}
public String getParticipant_type() {
	return participant_type;
}
public void setParticipant_type(String participant_type) {
	this.participant_type = participant_type;
}
@Override
public String toString() {
	return "gunviolence [incident_id=" + incident_id + ", date=" + date + ", state=" + state + ", city_or_county="
			+ city_or_county + ", address=" + address + ", n_killed=" + n_killed + ", n_injured=" + n_injured
			+ ", gun_stolen=" + gun_stolen + ", gun_type=" + gun_type + ", incident_characteristics="
			+ incident_characteristics + ", latitude=" + latitude + ", location_description=" + location_description
			+ ", longitude=" + longitude + ", n_guns_involved=" + n_guns_involved + ", notes=" + notes
			+ ", participant_age=" + participant_age + ", participant_age_group=" + participant_age_group
			+ ", participant_gender=" + participant_gender + ", participant_name=" + participant_name
			+ ", participant_relationship=" + participant_relationship + ", participant_status=" + participant_status
			+ ", participant_type=" + participant_type + ", injuredandkilled=" + injuredandkilled + "]";
}



}
