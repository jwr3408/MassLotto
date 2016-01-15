package com.kallafishapps.masslotto.shared;

import android.os.AsyncTask;

public class ApplicationLicense extends AsyncTask<Void, Void, Void> {

	//private static final String BASE64_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAmpPRPaj34Xfx3ya3cTg1MKrqx51sQf25XvFT9wrlBS9jPjEefNCdtCapb/ldfnkquazaH4yL2oLfTRiX8qAGC0uFya2mb8SE8mjqABv7zMgDxFP/rrGuR2+OqMtP+mDvuB3ti7Jh9SnbHB5clQcFklH58nZziYMdBjiwJ6kpxLulhCagI9pqdVN+ejfh0rb+chvNr1jzJJuLN54Jrd6s8SpCNqmcbo2l7gLVhi3CMLrdwcis73XLH3kxP05Fe5CDHnUimCQBZgN1UhFU7JlObGiWUalsfjoJCaojGVJQVLqiPiShRF4NhqSCJiZuDvmvlchHFndlDtWjCUBDr2BR8wIDAQAB";

	//private static final byte[] SALT = new byte[] { -4, 29, 6, -8, -103, -57, 5, -13, 51, 10, -20, -45, 4, -10, -36, -113, -11, 25, -64, 89 };

	//private LicenseChecker licenseChecker = null;
	
	@Override
	protected Void doInBackground(Void... params)
	{
		CheckApplicationLicense();
		return null;
	}

	private void CheckApplicationLicense()
	{

	}

}
