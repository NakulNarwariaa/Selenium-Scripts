package sample;



import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;




public class RunScripts {
	 Excel e1=new Excel();
	static int i=0;
	static int first=0;
	@SuppressWarnings("rawtypes")
	public AndroidDriver dr;

  @Test(invocationCount=1)
  public void AllTestCases() throws Exception {
	  long startTime= System.currentTimeMillis();
	  
	 if(first==0){
	  try{
		 
		  e1.main(null);
		  first++;
	  }
	  catch(Exception e)
	  {
		  System.out.println("Exception While writing zeros to the excel sheet " +e);
	  }
	 }
	  
	  
	  try{
	    AppSearch a1=new AppSearch();
		a1.beforeMethod();
		a1.SearchAnApp();
		a1.afterMethod();
	  }
	  catch(Exception e)
	  {
		  System.out.println("Exception while executing App Search Test Cases: Configuration class" +e);
	  }
	  
try{
		ChangeWallpaper a2=new ChangeWallpaper();
		a2.beforeMethod();
		a2.ChangeWallpapers();
		a2.afterMethod();
  }
  catch(Exception e)
  {
	  System.out.println("Exception while executing Change Wallpaper Test Cases: Configuration class " +e );
  }

try{
		ClearLauncher a3=new ClearLauncher();
		a3.setUp();
		a3.clearLauncher();
		a3.quit();
}
catch(Exception e)
{
	  System.out.println("Exception while executing Clear Launcher Test Cases: Configuration class " +e );
}	

try{
		DefaultShortcutsOnHomescreen a4=new DefaultShortcutsOnHomescreen();
		a4.beforeMethod();
		a4.DefaultAppsAndWidgets();
		a4.afterMethod();
}
catch(Exception e)
{
	  System.out.println("Exception while executing Default Shortcut on Homescreen Test Cases: Configuration class " +e );
}	

try{
		InstallFromPlaystore a5=new InstallFromPlaystore();
		a5.setUp();
		a5.PlaystoreTest();
		a5.quit();
}
catch(Exception e)
{
	  System.out.println("Exception while executing Install from Playstore Test Cases: Configuration class " +e );
}
		

try{
	LaunchApps a10=new LaunchApps();
	a10.beforeMethod();
	a10.LaunchAppsFromAppTray();
	a10.afterMethod();
 }
  catch(Exception e)
  {
	  System.out.println("Exception while executing Launch Apps Test Cases: Configuration class " +e );
  }

try{
		PlacingWidgets a6=new PlacingWidgets();
		a6.beforeMethod();
		a6.PlacingWidgetsAndRemove();
		a6.afterMethod();
}
catch(Exception e)
{
	  System.out.println("Exception while executing Placing & removing Test Cases: Configuration class " +e );
}	
	
		
	try{
		Uninstall a8=new Uninstall();
		a8.setUp();
		a8.Uninstall();
		a8.quit();
	 }
	  catch(Exception e)
	  {
		  System.out.println("Exception while executing uninstall Test Cases: Configuration class " +e );
	  }
	

try{
		ScrollWidgets a7=new ScrollWidgets();
		a7.beforeMethod();
		a7.WidgetsScrollTime();
		a7.afterMethod();
  }
  catch(Exception e)
  {
	  System.out.println("Exception while executing scroll widgets Test Cases: Configuration class " +e );
  }	

	try{
		WeatherWidgetFunctionality a9=new WeatherWidgetFunctionality();
		a9.beforeMethod();
		a9.WeatherWidget();
		a9.afterMethod();
	 }
	  catch(Exception e)
	  {
		  System.out.println("Exception while executing Weather Widget Test Cases: Configuration class " +e );
	  }
		
	
	try{
		 TakeScreenshot a12=new TakeScreenshot();
		a12.beforeMethod();
		a12.ToCheckToast();
		a12.afterMethod();
	 }
	  catch(Exception e)
	  {
		  System.out.println("Exception while executing Weather Widget Test Cases: Configuration class " +e );
	  }
		
	
//	try{
//		CreateFolder a11=new CreateFolder();
//		a11.beforeMethod();
//		a11.CreatFolderOnWorkspace();
//		a11.afterMethod();
//	 }
//	  catch(Exception e)
//	  {
//		  System.out.println("Exception while executing create folder Test Cases: Configuration class " +e );
//	  }
//		
		
		
		
		
		 long endTime= System.currentTimeMillis();
		  long totalTime=endTime-startTime;
		  long tt=totalTime/1000;

		  System.out.println("Total time taken for " +i +" iteration = " +tt);
 
  }
  
  @SuppressWarnings("rawtypes")
@BeforeMethod
  public void beforeMethod() throws MalformedURLException  {
	  i++;
	 System.out.println("Started Running  " +i +" iteration");
  }

  @AfterMethod
  public void afterMethod() {
	  
		if (dr != null) {
			dr.quit();
		}
	
  }

}

