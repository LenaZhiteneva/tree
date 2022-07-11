package ru.ac.uniyar.mf.lzh;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class Node
{
    private String id;
    private String name;
    private List<Node> children;
    //private Node parent;
    //Integer id_memory = 0;

    public Node() { }

    public Node(String name)
    {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.children = new ArrayList<>();
    }

    public String getName()
    {
        return name;
    }

    public void add(Node child)
    {
        children.add(child);
    }

    public List<Node> getChildren()
    {
        return children;
    }


    public Node find(String name)
    {
        for (int i = 0; i < children.size(); i++)
        {
            if (children.get(i).getName() == name)
            {
                return children.get(i);
            }
        }
        return null;
    }

    public Node find_with_id(String id)
    {
        for (int i = 0; i < children.size(); i++)
        {
            if (children.get(i).getId() == id)
            {
                return children.get(i);
            }
        }
        return null;
    }

    public String getId()
    {
        return id;
    }

    public boolean delete_child(String id)
    {
        for (int i = 0; i < children.size(); i++)
        {
            if (children.get(i).getId() == id)
            {
                children.remove(i);
                return true;
            }
        }
        return false;
    }

    public void delete_children()
    {
        children.clear();
    }

    public void change_name(String name)
    {
        this.name = name;
    }

    @JsonIgnore
    public String get_tree()
    {
        return get_tree(0, "");
    }

    private String get_tree(int level, String str)
    {
        for (int i = 0; i < level; i++)
        {
            str += "_____";
        }
        str += this.name;
        str += "\n";
        if (children.size() == 0)
        {
            return str;
        }
        else
        {
            for (int i = 0; i < children.size(); i++)
            {
                str += children.get(i).get_tree(level + 1, "");
            }
            return str;
        }

    }

    private String get_tree_html(int level, String str)
    {
        str += "<ul>";
        for (int i = 0; i < level; i++)
        {
            str += "-----";
        }
        str += this.name + " <a href=\"edit_node/" + id + "\">Редактировать</a>";
        str += "</ul>";
        if (children.size() == 0)
        {
            return str;
        }
        else
        {
            for (int i = 0; i < children.size(); i++)
            {
                str += children.get(i).get_tree_html(level + 1, "");
            }
            return str;
        }

    }

    public void to_file() throws IOException
    {
        String for_file = get_tree(0, "");
        String path = "file.txt";
        Files.write(Paths.get(path), for_file.getBytes());
    }

    public void to_file_json(Node node) throws IOException
    {
        ObjectMapper objectMapper = new ObjectMapper();
        String for_file = objectMapper.writeValueAsString(node);
        String path = "file_for_json.txt";
        Files.write(Paths.get(path), for_file.getBytes());
    }

    public String forHTML()
    {
        String result = "";
        result += get_tree_html(0,"");
        result += "</ul>";
        return result;
    }
}
