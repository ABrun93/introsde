package soap.document.client;

import java.util.List;

import soap.document.webservice.PeopleService;
import soap.document.webservice.PeopleInterface;
import soap.document.webservice.Person;

public class PeopleClient{
    public static void main(String[] args) throws Exception {
        PeopleService service = new PeopleService();
        PeopleInterface people = service.getPeopleImplementationPort();
        Person p = people.readPerson(1);
        List<Person> pList = people.getPeopleList();
        System.out.println("Result ==> "+p);
        System.out.println("Result ==> "+pList);
        System.out.println("First Person in the list ==> "+pList.get(0).getName());
    }
}
