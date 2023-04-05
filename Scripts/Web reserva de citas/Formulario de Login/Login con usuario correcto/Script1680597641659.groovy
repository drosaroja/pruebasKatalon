import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

'Abrir el Navegador'
WebUI.openBrowser('')

try {
    'Navegar a la página'
    WebUI.navigateToUrl('https://katalon-demo-cura.herokuapp.com/')

    'Hacer click en botón appointment'
    WebUI.click(findTestObject('Web reserva de citas/Formulario de Login/Botón de reserva cita'))

    'Rellenar un usuario que exista'
    WebUI.sendKeys(findTestObject('Web reserva de citas/Formulario de Login/Input del nombre de usuario'), nombre_usuario)

    'Rellenar su contraseña'
    WebUI.sendKeys(findTestObject('Web reserva de citas/Formulario de Login/Input de la contraseña'), password_usuario)

    'Hacer click en el botón login'
    WebUI.click(findTestObject('Web reserva de citas/Formulario de Login/Botón de Login'))

    'Hacer click en el botón menú'
    WebUI.click(findTestObject('Web reserva de citas/Menú de la aplicación/Botón mostrar menú'))

    'Verificar que exista un elemento con el texto logout en el menú'
    WebUI.verifyElementPresent(findTestObject('Web reserva de citas/Menú de la aplicación/Botón de logout'), 0)

    'Extraer el texto logout'
    texto_logout = WebUI.getText(findTestObject('Web reserva de citas/Menú de la aplicación/Botón de logout'))

    'Ver que hayamos hecho el logout'
    titulo_formulario_cita = WebUI.getText(findTestObject('Web reserva de citas/Formulario de Solicitar cita/Título del formulario de solicitar cita'))
}
finally { 
    'Cerrar el navegador'
    WebUI.closeBrowser()
}

'Asegurarse de que el formulario tiene el título correcto'
WebUI.verifyEqual(titulo_formulario_cita, 'Make Appointment')

WebUI.verifyEqual(texto_logout, 'Logout')

