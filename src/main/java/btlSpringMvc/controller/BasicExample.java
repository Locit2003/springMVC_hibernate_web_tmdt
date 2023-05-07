package btlSpringMvc.controller;

public class BasicExample {
	private String captchaCode, captchaCorrect, captchaIncorrect;

	public String getCaptchaCode() {
		return captchaCode;
	}

	public void setCaptchaCode(String userCaptchaCode) {
		this.captchaCode = userCaptchaCode;
	}

	public String getCaptchaCorrect() {
		return captchaCorrect;
	}

	public void setCaptchaCorrect(String captchaCorrect) {
		this.captchaCorrect = captchaCorrect;
	}

	public String getCaptchaIncorrect() {
		return captchaIncorrect;
	}

	public void setCaptchaIncorrect(String captchaIncorrect) {
		this.captchaIncorrect = captchaIncorrect;
	}
}
