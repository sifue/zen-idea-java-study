package projava;

import java.sql.Struct;

public class InstanceMethodSample {

    record Student(String name, int englishScore, int mathScore){
        int average() {
            return (this.englishScore() + this.mathScore()) / 2;
        }


        public int maxScore() {
            return Math.max(this.englishScore(), this.mathScore());
        }
    }

    static void main(String[] args) {
        var kis = new Student("kis", 60, 80);

        var a = kis.average();

        System.out.println("平均点は %d です".formatted(a));

        int max = kis.maxScore();

        System.out.println("最高点は %d です".formatted(max));
    }


}
