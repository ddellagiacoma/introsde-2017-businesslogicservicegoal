package com.businesslogic.goal.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.WebResult;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import com.businesslogic.goal.model.Goal;
import com.businesslogic.goal.model.Person;


@WebService
@SOAPBinding(style = Style.DOCUMENT, use=Use.LITERAL) 
public interface BusinessLogicGoal {

    @WebMethod(operationName="ChangeWeightControl")
    @WebResult(name="sentenceWeight")
    public String ChangeWeightControl(@WebParam(name="personId") int id, @WebParam(name="access_token") String access_token, @WebParam(name="userId") String userId, @WebParam(name="refresh") String refresh, @WebParam(name="status") String status, @WebParam(name="startWeight") double startWeight);

    @WebMethod(operationName="ChangeStepsControl")
    @WebResult(name="sentenceSteps") 
    public String ChangeStepsControl(@WebParam(name="personId") int id, @WebParam(name="access_token") String access_token, @WebParam(name="userId") String userId, @WebParam(name="refresh") String refresh, @WebParam(name="diffGoal") int diffGoal, @WebParam(name="lifeStyle") String lifeStyle,  @WebParam(name="diffSteps") int diffSteps,  @WebParam(name="steps") int steps);

    @WebMethod(operationName="ChangeCaloriesControl")
    @WebResult(name="sentenceCalories") 
    public String ChangeCaloriesControl(@WebParam(name="personId") int id, @WebParam(name="access_token") String access_token, @WebParam(name="userId") String userId, @WebParam(name="refresh") String refresh, @WebParam(name="diffGoal") int diffGoal, @WebParam(name="lifeStyle") String lifeStyle,  @WebParam(name="diffCalories") int diffCalories,  @WebParam(name="calories") int calories);

    @WebMethod(operationName="ChangeDistanceControl")
    @WebResult(name="sentenceDistance") 
    public String ChangeDistanceControl(@WebParam(name="personId") int id, @WebParam(name="access_token") String access_token, @WebParam(name="userId") String userId, @WebParam(name="refresh") String refresh, @WebParam(name="diffGoal") int diffGoal, @WebParam(name="lifeStyle") String lifeStyle,  @WebParam(name="diffDistance") double diffDistance,  @WebParam(name="distance") double distance);

}