package evidence.models.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class InsuranceDTO {

    private long id;

    @NotBlank(message = "Druh pojištění je povinný")
    private String insuranceType;

    @NotNull(message = "Částka je povinná")
    @Min(value = 1, message = "Částka musí být větší než 0")
    private Integer amount;

    @NotBlank(message = "Předmět pojištění je povinný")
    private String insuredSubject;

    @NotNull(message = "Platnost od je povinná")
    private LocalDate dateFrom;

    @NotNull(message = "Platnost do je povinná")
    private LocalDate dateTo;

    private long insuredId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getInsuranceType() {
        return insuranceType;
    }

    public void setInsuranceType(String insuranceType) {
        this.insuranceType = insuranceType;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getInsuredSubject() {
        return insuredSubject;
    }

    public void setInsuredSubject( String insuredSubject) {
        this.insuredSubject = insuredSubject;
    }

    public long getInsuredId() {
        return insuredId;
    }

    public void setInsuredId(long insuredId) {
        this.insuredId = insuredId;
    }
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
    }
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public LocalDate getDateTo() {
        return dateTo;
    }

    public void setDateTo(LocalDate dateTo) {
        this.dateTo = dateTo;
    }
}
