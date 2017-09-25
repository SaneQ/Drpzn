import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ReactDrpzn {
    JavascriptExecutor executor;

    public ReactDrpzn() {
        Configuration.browser = "chrome";
        this.executor = (JavascriptExecutor) WebDriverRunner.getWebDriver();
    }
    private By dropzone = By.cssSelector(".filepicker.dropzone.dz-clickable");

    @Test
    public void drzon() throws IOException, InterruptedException {
        open("http://reactdropzone.azurewebsites.net/example");
        $(dropzone).hover();
        String script = "var myZone, blob, base64Image; myZone = Dropzone.forElement('.filepicker.dropzone.dz-clickable');" +
                "base64Image = 'iVBORw0KGgoAAAANSUhEUgAAAO0AAABQCAYAAAD1GfIkAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsIAAA7CARUoSoAAAAEGSURBVHhe7dPBCcAwAAMxp/vv3ObRJQ4kMJ7gzrb3Doh4/gciRAsxooUY0UKMaCFGtBAjWogRLcSIFmJECzGihRjRQoxoIUa0ECNaiBEtxIgWYkQLMaKFGNFCjGghRrQQI1qIES3EiBZiRAsxooUY0UKMaCFGtBAjWogRLcSIFmJECzGihRjRQoxoIUa0ECNaiBEtxIgWYkQLMaKFGNFCjGghRrQQI1qIES3EiBZiRAsxooUY0UKMaCFGtBAjWogRLcSIFmJECzGihRjRQoxoIUa0ECNaiBEtxIgWYkQLMaKFGNFCjGghRrQQI1qIES3EiBZiRAsxooUY0UKMaCFGtBAjWkjZPk/PAZ8fwt/rAAAAAElFTkSuQmCC';" +
                "function base64toBlob(r,e,n){e=e||\"\",n=n||512;for(var t=atob(r),a=[],o=0;o<t.length;o+=n){for(var l=t.slice(o,o+n),h=new Array(l.length),b=0;b<l.length;b++)h[b]=l.charCodeAt(b);var v=new Uint8Array(h);a.push(v)}var c=new Blob(a,{type:e});return c}" +
                "blob = base64toBlob(base64Image, 'image / png');" +
                "blob.name = 'file.png';" +
                "myZone.addFile(blob);";

        executor.executeScript(script);
        Thread.sleep(3000);//смотрим результат
    }
}
