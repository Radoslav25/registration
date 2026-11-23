package no.hvl.dat108.f11;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Registration {

	@NotBlank(message="First name Required")
	private String fornavn;
	
	@NotNull(message="Last name Required")
	@Size(min=1, max=69, message="name between 1 and 69")
	@Pattern(regexp="^[A-Za-z]+$", message="invalid regExpression")
	private String etternavn;
	
	@NotBlank(message="tel required")
	@Pattern(regexp="^\\d{8}$", message="8 digits required")
	private String tel;
	
	@NotBlank(message = "Gender is required")
    @Pattern(regexp = "^(male|female)$", message = "Invalid gender")
    private String kjonn;

	@NotBlank(message="password required")
	@Size(min=6, message="Password must contain at least 6 characters. Big Letter, Symbol, Number, Small Letter")
	private String passord;
	
	@NotBlank(message="repeat password required")
	private String repetertPassord;

	public String getFornavn() {
		return fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public String getTel() {
		return tel;
	}

	public String getPassord() {
		return passord;
	}

	public String getRepetertPassord() {
		return repetertPassord;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public void setPassord(String passord) {
		this.passord = passord;
	}

	public void setRepetertPassord(String repetertPassord) {
		this.repetertPassord = repetertPassord;
	}

	public String getKjonn() {
        return kjonn;
    }

    public void setKjonn(String kjonn) {
        this.kjonn = kjonn;
    }
}

