/**
 *@Copyright:Copyright (c) 2014
 */
package com.util;

import org.junit.Test;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
/**
 *@Author kklt21cn
 *@Since 2014年7月16日
 *@Version 1.0
 */

public class PageNoUtilTest {
	@Test
	public void getPageAccount(){
		int pageAccount = PageNoUtil.getPageAccount(100);
		assertThat(pageAccount,is(10));
		int pageAccount2 = PageNoUtil.getPageAccount(99);
		assertThat(pageAccount,is(10));
	}
}
