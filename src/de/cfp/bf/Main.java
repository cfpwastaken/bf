package de.cfp.bf;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static int[] cells;

    public static void main(String[] args) {
        if(args.length == 1) {
            String program = args[0];
            File file = new File(program);
            try {
                Scanner scan = new Scanner(file);
                StringBuilder builder = new StringBuilder();
                int cellamount = 30000;
                while(scan.hasNext()) {
                    String next = scan.next();
                    if(next.startsWith("!")) cellamount = Integer.parseInt(next.substring(1));
                    else if(!next.startsWith("#")) builder.append(next);
                }

                cells = new int[cellamount];

                String text = builder.toString();
                System.out.println(text);

                // Analyse the program
                if(!analyse(text)) {
                    System.err.println("Invalid Code! Code does not have same amount of [ as ]");
                    System.exit(1);
                }

                // Interpret the program

                int pointer = 0;
                int[] loops = new int[400];
                int nextLoop = 0;

                // for every character
                for(int i = 0; i < text.length(); i++) {
                    char c = text.charAt(i);
                    if(c == '>') {
                        if((pointer + 1) > (cells.length - 1)) {
                            pointer = 0;
                        } else {
                            pointer++;
                        }
                    }
                    else if(c == '<') {
                        if((pointer - 1) < 0) {
                            pointer = cells.length - 1;
                        } else {
                            pointer--;
                        }
                    }
                    else if(c == '+') {
                        if(!((cells[pointer] + 1) >= 255)) cells[pointer]++;
                    }
                    else if(c == '-') {
                        if(!((cells[pointer] - 1) < 0)) cells[pointer]--;
                        else cells[pointer] = 255;
                    }
                    else if(c == '.') System.out.print((char) cells[pointer]);
                    else if(c == ':') System.out.println(cells[pointer]);
                    else if(c == '?') System.out.println(pointer);
                    else if(c == ',') cells[pointer] = System.in.read();
                    else if(c == '[') {
                        loops[nextLoop] = i;
                        nextLoop += 1;
                    }
                    else if(c == ']') {
                        if(cells[pointer] != 0) {
                            i = loops[nextLoop];
                        } else {
                            if(nextLoop != 0) i = loops[nextLoop] + 1;
                            loops[nextLoop] = 0;
                            if(nextLoop >= 1) nextLoop--;
                        }
                    }
                }
            } catch (FileNotFoundException e) {
                System.err.println(program + " not found.");
            } catch(IOException e) {
                System.err.println("IOException");
            }
        } else {
            System.out.println("Usage: java -jar bf.jar code.bf");
        }
    }

    public static boolean analyse(String code) {
        char open = '[';
        char close = ']';
        int cOpen = 0;
        int cClose = 0;

        for (int i = 0; i < code.length(); i++) {
            if (code.charAt(i) == open) {
                cOpen++;
            } else if(code.charAt(i) == close) {
                cClose++;
            }
        }

        return cOpen == cClose;
    }

}
