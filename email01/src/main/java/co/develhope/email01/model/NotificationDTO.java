package co.develhope.email01.model;
//defines a NotificationDTO that consists of the following strings:
//contactId
//title
//text

import javax.persistence.*;

@Entity
@Table
public class NotificationDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int contactId;
    private String title;
    private String text;

    public NotificationDTO(){

    }

    public NotificationDTO(String contactId, String title, String text){

    }

    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
