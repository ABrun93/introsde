
package soap.document.webservice;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.Holder;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "PeopleInterface", targetNamespace = "http://webservice.document.soap/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface PeopleInterface {


    /**
     * 
     * @param personId
     * @return
     *     returns soap.document.webservice.Person
     */
    @WebMethod
    @WebResult(name = "person", targetNamespace = "http://webservice.document.soap/")
    @RequestWrapper(localName = "readPerson", targetNamespace = "http://webservice.document.soap/", className = "soap.document.webservice.ReadPerson")
    @ResponseWrapper(localName = "readPersonResponse", targetNamespace = "http://webservice.document.soap/", className = "soap.document.webservice.ReadPersonResponse")
    @Action(input = "http://webservice.document.soap/PeopleInterface/readPersonRequest", output = "http://webservice.document.soap/PeopleInterface/readPersonResponse")
    public Person readPerson(
        @WebParam(name = "personId", targetNamespace = "")
        int personId);

    /**
     * 
     * @return
     *     returns java.util.List<soap.document.webservice.Person>
     */
    @WebMethod
    @WebResult(name = "people", targetNamespace = "")
    @RequestWrapper(localName = "getPeopleList", targetNamespace = "http://webservice.document.soap/", className = "soap.document.webservice.GetPeopleList")
    @ResponseWrapper(localName = "getPeopleListResponse", targetNamespace = "http://webservice.document.soap/", className = "soap.document.webservice.GetPeopleListResponse")
    @Action(input = "http://webservice.document.soap/PeopleInterface/getPeopleListRequest", output = "http://webservice.document.soap/PeopleInterface/getPeopleListResponse")
    public List<Person> getPeopleList();

    /**
     * 
     * @param person
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(name = "personId", targetNamespace = "")
    @RequestWrapper(localName = "createPerson", targetNamespace = "http://webservice.document.soap/", className = "soap.document.webservice.CreatePerson")
    @ResponseWrapper(localName = "createPersonResponse", targetNamespace = "http://webservice.document.soap/", className = "soap.document.webservice.CreatePersonResponse")
    @Action(input = "http://webservice.document.soap/PeopleInterface/createPersonRequest", output = "http://webservice.document.soap/PeopleInterface/createPersonResponse")
    public int createPerson(
        @WebParam(name = "person", targetNamespace = "http://webservice.document.soap/")
        Person person);

    /**
     * 
     * @param person
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(name = "personId", targetNamespace = "")
    @RequestWrapper(localName = "updatePerson", targetNamespace = "http://webservice.document.soap/", className = "soap.document.webservice.UpdatePerson")
    @ResponseWrapper(localName = "updatePersonResponse", targetNamespace = "http://webservice.document.soap/", className = "soap.document.webservice.UpdatePersonResponse")
    @Action(input = "http://webservice.document.soap/PeopleInterface/updatePersonRequest", output = "http://webservice.document.soap/PeopleInterface/updatePersonResponse")
    public int updatePerson(
        @WebParam(name = "person", targetNamespace = "http://webservice.document.soap/")
        Person person);

    /**
     * 
     * @param personId
     */
    @WebMethod
    @RequestWrapper(localName = "deletePerson", targetNamespace = "http://webservice.document.soap/", className = "soap.document.webservice.DeletePerson")
    @ResponseWrapper(localName = "deletePersonResponse", targetNamespace = "http://webservice.document.soap/", className = "soap.document.webservice.DeletePersonResponse")
    @Action(input = "http://webservice.document.soap/PeopleInterface/deletePersonRequest", output = "http://webservice.document.soap/PeopleInterface/deletePersonResponse")
    public void deletePerson(
        @WebParam(name = "personId", targetNamespace = "", mode = WebParam.Mode.INOUT)
        Holder<Integer> personId);

    /**
     * 
     * @param personId
     * @param healthProfile
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(name = "hpId", targetNamespace = "")
    @RequestWrapper(localName = "updatePersonHealthProfile", targetNamespace = "http://webservice.document.soap/", className = "soap.document.webservice.UpdatePersonHealthProfile")
    @ResponseWrapper(localName = "updatePersonHealthProfileResponse", targetNamespace = "http://webservice.document.soap/", className = "soap.document.webservice.UpdatePersonHealthProfileResponse")
    @Action(input = "http://webservice.document.soap/PeopleInterface/updatePersonHealthProfileRequest", output = "http://webservice.document.soap/PeopleInterface/updatePersonHealthProfileResponse")
    public int updatePersonHealthProfile(
        @WebParam(name = "personId", targetNamespace = "")
        int personId,
        @WebParam(name = "healthProfile", targetNamespace = "")
        LifeStatus healthProfile);

}
