package ru.ac.uniyar.mf.lzh;

import javax.ws.rs.core.Application;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WebApplication extends Application
{
    private List<String> list = new ArrayList<>();
    private Node root;

    public WebApplication()
    {
        list.add("aaa");
        root = new Node("Root");
        Node child1 = new Node("Лист1");
        Node child2 = new Node("Лист2");
        Node child3 = new Node("Лист3");
        Node child4 = new Node("Лист4");
        Node child5 = new Node("Лист5");
        root.add(child1);
        root.add(child2);
        root.getChildren().get(0).add(child3);
        root.getChildren().get(0).add(child4);
        root.getChildren().get(1).add(child5);
    }

    @Override
    public Set<Object> getSingletons()
    {
        Set<Object> resources = new HashSet<>();
        resources.add(new ListPresentationController(list, root));
        return resources;
    }
}
