package com.example.demo.exception;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class SkillNotCreatedException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private String message;
	private int statusCode;
	private long errorReportringTime;
	public SkillNotCreatedException(String message) {
		super();
		this.message=message;
	}

}
