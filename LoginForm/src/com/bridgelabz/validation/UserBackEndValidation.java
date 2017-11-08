package com.bridgelabz.validation;

import com.bridgelabz.model.User;

public class UserBackEndValidation {

	public String checkValidation(User user) {

		String msg = null;

		String NameRegx = "^\\w+\\s{1}\\w+$";

		/*
		 * w - word s - space + Quantifier — Matches between one and unlimited times, as
		 * many times as possible to add more word and space = \s{1}\w+
		 */

		String EmailRegx = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$";

		String PassRegx = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?!.*\\s).{8,15}$";

		String MobileRegx = "^\\d{10}$";

		if (user.getName().matches(NameRegx)) {

			if (user.getEmail().matches(EmailRegx)) {

				if (user.getPassword().matches(PassRegx)) {

					if (user.getRepassword().equals(user.getRepassword())) {

						if (user.getMobile().matches(MobileRegx)) {

							if (!user.getBirth().isEmpty()) {

								msg = null;

							} else {

								msg = "Select Date of Birth..!";
							}

						} else {

							msg = "Wrong Mobile Number...!Mobile Number must have 10 Digit";
						}
					} else {

						msg = "Repeated Password not match...!";
					}
				} else {

					msg = "'Wrong Password...! Password must consists of at least six characters that are a combination of letters, numbers and symbols (@, #, $, %, etc.)";
				}
			} else {

				msg = "Wrong Email Format..!Email should be like abc@gmail.com";

			}
		} else {

			System.out.println("Sorry, username error!");

			msg = "Sorry, username error!";

		}

		return msg;
	}

}
