package template;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true) // Bỏ qua các trường
public class TaskTemplate {
    public static List<TaskTemplate> tasks = new ArrayList<TaskTemplate>();
    public int ID;
    public String name;
    public int npcFrom;
    public int npcTo;
    public boolean isMain;
    public String strShortDetail;
    public String strDetailTalk;
    public String strDetailHelpFinish;
    public String strDetailTalkFinish;
    public String strDetailHelp;
    public short[][] arrQuest;
    
    public byte typeQuest;
    public byte typeItem;

    public static class Builder {
        public int ID;
        public String name;
        public int npcFrom;
        public int npcTo;     
        public boolean isMain;
        public String strShortDetail;
        public String strDetailTalk;
        public String strDetailHelpFinish;
        public String strDetailTalkFinish;
        public String strDetailHelp;
        public short[][] arrQuest;
        
        public byte typeItem;

        public TaskTemplate build() {
            TaskTemplate task = new TaskTemplate();
            task.ID = ID;
            task.name = name;
            task.npcFrom = npcFrom;
            task.npcTo = npcTo;         
            task.isMain = isMain;
            task.strShortDetail = strShortDetail;
            task.strDetailTalk = strDetailTalk;
            task.strDetailHelpFinish = strDetailHelpFinish;
            task.strDetailTalkFinish = strDetailTalkFinish;
            task.strDetailHelp = strDetailHelp;
            task.arrQuest = arrQuest;
            
            task.typeItem = typeItem;
            return task;
        }

        public Builder setID(int ID) {
            this.ID = ID;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setNpcFrom(int npcFrom) {
            this.npcFrom = npcFrom;
            return this;
        }

        public Builder setNpcTo(int npcTo) {
            this.npcTo = npcTo;
            return this;
        }

        public Builder setMain(boolean main) {
            isMain = main;
            return this;
        }

        public Builder setStrShortDetail(String strShortDetail) {
            this.strShortDetail = strShortDetail;
            return this;
        }

        public Builder setStrDetailTalk(String strDetailTalk) {
            this.strDetailTalk = strDetailTalk;
            return this;
        }

        public Builder setStrDetailHelpFinish(String strDetailHelpFinish) {
            this.strDetailHelpFinish = strDetailHelpFinish;
            return this;
        }

        public Builder setArrQuest(short[][] arrQuest) {
            this.arrQuest = arrQuest;
            return this;
        }
        
        

        public Builder setTypeItem(byte typeItem) {
            this.typeItem = typeItem;
            return this;
        }

        public Builder setStrDetailHelp(String strDetailHelp) {
            this.strDetailHelp = strDetailHelp;
            return this;
        }

        public Builder setStrDetailTalkFinish(String strDetailTalkFinish) {
            this.strDetailTalkFinish = strDetailTalkFinish;
            return this;
        }
    }


    public static void setTasks() {
    ObjectMapper objectMapper = new ObjectMapper();

    try {
        // Đọc danh sách nhiệm vụ từ file
        List<TaskTemplate> tasksFromFile = objectMapper.readValue(
            new File("data/nhiemvu/nhiemvu.txt"), 
            objectMapper.getTypeFactory().constructCollectionType(List.class, TaskTemplate.class)
        );

        // Thêm tất cả nhiệm vụ vào danh sách `tasks`
        tasks.addAll(tasksFromFile);

    } catch (IOException e) {
        e.printStackTrace();
    }
}

    public static TaskTemplate getTask(List<TaskTemplate> tasks, int ID, boolean isMain) {
    for (TaskTemplate task : tasks) {
        if (task.ID == ID && task.isMain == task.isMain) {
            return task;
        }
    }
    return null;
}

}
