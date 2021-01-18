package edu.gzu.lms.entity;

import java.sql.Date;

public class Borrow {
    private int borrowId;
    private int bookId;
    private int readerId;
    private Date lendDate;
    private Date backDate;

    public Borrow() {
    }

    public Borrow(int borrowId, int bookId, int readerId, Date lendDate, Date backDate) {
        this.borrowId = borrowId;
        this.bookId = bookId;
        this.readerId = readerId;
        this.lendDate = lendDate;
        this.backDate = backDate;
    }

    public int getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(int borrowId) {
        this.borrowId = borrowId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getReaderId() {
        return readerId;
    }

    public void setReaderId(int readerId) {
        this.readerId = readerId;
    }

    public Date getLendDate() {
        return lendDate;
    }

    public void setLendDate(Date lendDate) {
        this.lendDate = lendDate;
    }

    public Date getBackDate() {
        return backDate;
    }

    public void setBackDate(Date backDate) {
        this.backDate = backDate;
    }

    @Override
    public String toString() {
        return "LendList{" +
                "serNum=" + borrowId +
                ", bookId=" + bookId +
                ", readerId=" + readerId +
                ", lendDate=" + lendDate +
                ", backDate=" + backDate +
                '}';
    }
}
