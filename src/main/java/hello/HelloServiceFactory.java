package hello;
import org.python.core.Py;
import org.python.core.PyObject;
import org.python.core.PyString;
import org.python.core.PySystemState;
import org.python.util.PythonInterpreter;
import org.springframework.beans.factory.FactoryBean;


public class HelloServiceFactory implements FactoryBean<HelloService> {

    @Override
    public HelloService getObject() throws Exception{

        // Set system enviroment
//        PySystemState systemState = Py.getSystemState();
//        systemState.path.append(new PyString("C:\\Users\\diogo.watson\\Downloads\\jython2.7.1\\Lib"));


        PythonInterpreter interpreter = new PythonInterpreter();
        interpreter.execfile("HelloServicePython.py");
        PyObject buildingObject = interpreter.get("HelloServicePython").__call__();

        return (HelloService)buildingObject.__tojava__(HelloService.class);
    }

    @Override
    public Class<?>getObjectType(){
        return HelloService.class;
    }

}
