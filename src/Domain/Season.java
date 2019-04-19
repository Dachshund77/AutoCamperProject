package Domain;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Season {
    private int seasonID;
    private Date offSeasonStart;
    private Date OffSeasonEnd;
    private Date inSeasonStart;
    private Date inSeasonEnd;
    private DateFormat creationDate = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");

    public Season(int seasonID, Date offSeasonStart, Date offSeasonEnd, Date inSeasonStart, Date inSeasonEnd, DateFormat creationDate) {
        this.seasonID = seasonID;
        this.offSeasonStart = offSeasonStart;
        OffSeasonEnd = offSeasonEnd;
        this.inSeasonStart = inSeasonStart;
        this.inSeasonEnd = inSeasonEnd;
        this.creationDate = creationDate;
    }

    public int getSeasonID() {
        return seasonID;
    }

    public void setSeasonID(int seasonID) {
        this.seasonID = seasonID;
    }

    public Date getOffSeasonStart() {
        return offSeasonStart;
    }

    public void setOffSeasonStart(Date offSeasonStart) {
        this.offSeasonStart = offSeasonStart;
    }

    public Date getOffSeasonEnd() {
        return OffSeasonEnd;
    }

    public void setOffSeasonEnd(Date offSeasonEnd) {
        OffSeasonEnd = offSeasonEnd;
    }

    public Date getInSeasonStart() {
        return inSeasonStart;
    }

    public void setInSeasonStart(Date inSeasonStart) {
        this.inSeasonStart = inSeasonStart;
    }

    public Date getInSeasonEnd() {
        return inSeasonEnd;
    }

    public void setInSeasonEnd(Date inSeasonEnd) {
        this.inSeasonEnd = inSeasonEnd;
    }

    public DateFormat getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(DateFormat creationDate) {
        this.creationDate = creationDate;
    }
}
