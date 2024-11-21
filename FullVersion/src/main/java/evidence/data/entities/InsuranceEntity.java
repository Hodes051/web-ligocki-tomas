package evidence.data.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;


@Entity
@Table(name = "insurance")
public class InsuranceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Druh pojištění je povinný")
    @Column(nullable = false)
    private String insuranceType;

    @NotNull(message = "Částka je povinná")
    @Min(value = 1, message = "Částka musí být větší než 0")
    @Column(nullable = false)
    private Integer amount;

    @NotBlank(message = "Předmět pojištění je povinný")
    @Column(nullable = false)
    private String insuredSubject;

    @NotNull(message = "Platnost od je povinná")
    @Column(nullable = false)
    private LocalDate dateFrom;

    @NotNull(message = "Platnost do je povinná")
    @Column(nullable = false)
    private LocalDate dateTo;

    @ManyToOne
    @JoinColumn(name = "insured_id", nullable = false)
    private InsuredEntity insured;

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

    public void setInsuredSubject(String insuredSubject) {
        this.insuredSubject = insuredSubject;
    }

    public InsuredEntity getInsured() {
        return insured;
    }

    public void setInsured(InsuredEntity insured) {
        this.insured = insured;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    public void setDateTo(LocalDate dateTo) {
        this.dateTo = dateTo;
    }
}


