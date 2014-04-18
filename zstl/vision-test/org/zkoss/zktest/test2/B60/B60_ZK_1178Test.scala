package org.zkoss.zktest.test2.B60

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "B60-ZK-1178.zul")
class B60_ZK_1178Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript = """<zk>
                    <zscript>
                      java.awt.image.BufferedImage bi = new java.awt.image.BufferedImage(
				200, 200, java.awt.image.BufferedImage.TYPE_INT_RGB
			);
			java.awt.Graphics2D g2 = bi.createGraphics();
			g2.setBackground(java.awt.Color.BLACK);
			g2.clearRect(0, 0, 200, 200);
			g2.dispose();
                    </zscript>
                    <label multiline="true">
                      1. When page load, it will show a black square image.
	2. click "next image", it will add a blue square image.
	3. click "next image" again, it will add a red square image. (before ZUL 2.2.3, it will occur "Cannot covert" exception.)
                    </label>
                    <div apply="org.zkoss.bind.BindComposer" viewModel="@id('vm') @init('org.zkoss.zktest.test2.B60_ZK_1178_Model')">
                      <image width="200px" height="200px" content="${bi}"/>
                      <image width="200px" height="200px" content="@load(vm.zkImage)"/>
                      <image width="200px" height="200px" content="@load(vm.renderedImage)"/>
                      <button label="next image" onClick="@command('update')"/>
                    </div>
                  </zk>"""

    runZTL(zscript,
      () => {
        verifyImage()
        click(jq(".z-button:eq(0)"))
        waitResponse()
        verifyImage()
        click(jq(".z-button:eq(0)"))
        waitResponse()
        verifyImage()
      })

  }
}
