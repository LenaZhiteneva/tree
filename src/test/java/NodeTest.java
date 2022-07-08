import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import ru.ac.uniyar.mf.lzh.Node;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NodeTest
{
    @Test
    void createNode()
    {
        Node node = new Node("Корень");
        assertEquals("Корень", node.getName());
    }

    @Test
    void addNode()
    {
        Node root = new Node("Корень");
        Node child = new Node("Лист");
        root.add(child);
        assertEquals(1, root.getChildren().size());
        assertEquals("Лист", root.getChildren().get(0).getName());
    }

    @Test
    void findNode()
    {
        Node root = new Node("Корень");
        Node child = new Node("Лист1");
        Node dop_child = new Node("Лист2");
        root.add(child);
        root.add(dop_child);
        assertEquals(2, root.getChildren().size());
        assertEquals(child, root.find("Лист1"));
    }

    @Test
    void deleteNode()
    {
        Node root = new Node("Корень");
        Node child = new Node("Лист1");
        Node dop_child = new Node("Лист2");
        root.add(child);
        root.add(dop_child);
        assertEquals(2, root.getChildren().size());
        root.delete_child(root.getChildren().get(0).getId());
        assertEquals(1, root.getChildren().size());
        root.delete_child(root.getChildren().get(0).getId());
        assertEquals(0, root.getChildren().size());
    }

    @Test
    void deleteAll()
    {
        Node root = new Node("Корень");
        Node child = new Node("Лист1");
        Node dop_child = new Node("Лист2");
        root.add(child);
        root.add(dop_child);
        assertEquals(2, root.getChildren().size());
        root.delete_children();
        assertEquals(0, root.getChildren().size());
    }

    @Test
    void changeNode()
    {
        Node root = new Node("Корень");
        Node child = new Node("Лист");
        root.add(child);
        assertEquals("Лист", root.getChildren().get(0).getName());
        root.getChildren().get(0).change_name("Ребёнок");
        assertEquals("Ребёнок", root.getChildren().get(0).getName());
    }

    @Test
    void getTree()
    {
        Node root = new Node("Корень");
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
        assertEquals(2, root.getChildren().get(0).getChildren().size());
        System.out.println(root.get_tree());
        assertEquals("Корень\n_____Лист1\n__________Лист3\n__________Лист4\n_____Лист2\n__________Лист5\n", root.get_tree());
    }

    @Test
    void to_file() throws IOException
    {
        Node root = new Node("Корень");
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

        assertEquals(2, root.getChildren().get(0).getChildren().size());
        root.to_file();
    }

    @Test
    void to_file_json() throws IOException
    {
        Node root = new Node("Корень");
        Node child1 = new Node("Лист1");
        Node child2 = new Node("Лист2");
        Node child3 = new Node("Лист3");
        root.add(child1);
        root.add(child2);
        root.getChildren().get(0).add(child3);

        root.to_file_json(root);
    }

    @Test
    void from_file_json() throws IOException
    {
        String str = "{\"id\":\"789321fe-5ab8-430f-a1ce-77383303e84b\",\"name\":\"Корень\",\"children\":[{\"id\":\"5cc263b6-5a7e-476f-9beb-4757352f8b65\",\"name\":\"Лист1\",\"children\":[{\"id\":\"5fbdcc07-1997-43bc-903a-1caa06aa7325\",\"name\":\"Лист3\",\"children\":[]}]},{\"id\":\"977fd449-c087-460f-8653-e4c5ef11ddf3\",\"name\":\"Лист2\",\"children\":[]}]}";
        ObjectMapper objectMapper = new ObjectMapper();
        Node root = objectMapper.readValue(str, Node.class);
        root.to_file();
    }
}
