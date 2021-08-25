package a_Programmers.KAKAO_BLIND_RECRUITMENT_2019;

import java.util.*;

// 2019 KAKAO BLIND RECRUITMENT
// 오픈채팅방

class Level2_OpenChattingRoom {
    public HashMap<String, String> id2nickname;
    public HashMap<String, ArrayList<Integer>> id2arr;
    public ArrayList<string> strings;

    public String[] solution(String[] record) {

        id2nickname = new HashMap<String, String>();
        id2arr = new HashMap<String, ArrayList<Integer>>();
        strings = new ArrayList<string>();

        for(int i=0; i<record.length; ++i){
            parseRecord(record[i]);
        }

        String[] answer = new String[strings.size()];
        for(int i=0; i<strings.size(); ++i){
            answer[i] = strings.get(i).nickname + strings.get(i).affix;
        }

        return answer;
    }

    public void parseRecord(String s){
        String[] tmp = s.split(" ");
        switch(tmp[0]){
            case "Enter" : {
                this.enter(s);
                break;
            }
            case "Leave" : {
                this.leave(s);
                break;
            }
            case "Change" : {
                this.change(s);
                break;
            }
        }
    }

    public void enter(String s){
        String[] str = s.split(" ");
        String id = str[1];
        String nickname = str[2];

        if(!id2nickname.containsKey(id)){
            id2nickname.put(id, nickname);
            id2arr.put(id, new ArrayList<Integer>());
        }
        else{
            change(s);
        }

        string input = new string(nickname, "님이 들어왔습니다.");
        strings.add(input);
        id2arr.get(id).add(strings.size()-1);
    }

    public void change(String s){
        String[] str = s.split(" ");
        String id = str[1];
        String nickname = str[2];

        id2nickname.replace(str[1], str[2]);
        for(Integer i : id2arr.get(id)){
            strings.get(i).change(str[2]);
        }
    }

    public void leave(String s){
        String[] str = s.split(" ");
        String id = str[1];

        string input = new string(id2nickname.get(str[1]), "님이 나갔습니다.");
        strings.add(input);
        id2arr.get(id).add(strings.size()-1);
    }

    public class string{
        public String nickname;
        public String affix;

        public string(String n, String a){
            this.nickname = n;
            this.affix = a;
        }

        public void change(String newNickname){
            this.nickname = newNickname;
        }
    }
}
