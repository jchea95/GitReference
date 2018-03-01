package com.example.juliechea.gitreference;



/**
 * Created by juliechea on 2/22/18.
 */

public class GitReference  {
    private String command;
    private String example;
    private String explanations;
    private String sections;
    public GitReference(String command, String example, String explanations, String sections){
        command = this.command;
        example = this.example;
        explanations = this.explanations;
        sections = this.sections;


    }

    public GitReference(){}



    public String getCommand(){
        return command;

    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getExample(){
        return example;

    }

    public void setExample(String example) {
        this.example = example;
    }

    public String getExplanations(){
        return explanations;
    }

    public void setExplanations(String explanations) {
        this.explanations = explanations;
    }

    public String getSections(){
        return sections;

    }

    public void setSections(String sections) {
        this.sections = sections;
    }


}
