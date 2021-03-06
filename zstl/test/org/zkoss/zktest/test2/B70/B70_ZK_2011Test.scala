package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "B70-ZK-2011.zul")
class B70_ZK_2011Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2011.zul

	Purpose:
		
	Description:
		
	History:
		Tue, Nov 12, 2013 10:37:36 AM, Created by jumperchen

Copyright (C) 2013 Potix Corporation. All Rights Reserved.

-->
<vbox>
If you cannot see any error message or dialog, this bug is fixed.
<zscript><![CDATA[
ListModelList model = new ListModelList();
model.add("A");
model.add("B");
model.add("C");
]]></zscript>
<tabbox onCreate='self.setModel(model);model.addToSelection("B")'>
	<template name="model:tab">
		<tab label="${each}"></tab>
	</template>
	<template name="model:tabpanel">
		<tabpanel>Panel ${each}
			<button label="click me ${each}" onClick="//do nothing"></button>
		</tabpanel>
	</template>
</tabbox>
<button label="click me out side" onClick="//do nothing"></button>

<!-- <selectbox onCreate='self.setModel(model);model.addToSelection("B")'/> -->
</vbox>
"""  
  runZTL(zscript,
    () => {
      verifyFalse("no exception", jq(".z-window-modal").exists());
    })
    
  }
}