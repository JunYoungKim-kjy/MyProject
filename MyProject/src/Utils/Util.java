package Utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Util {
	private static Scanner sc = new Scanner(System.in);
	private static Random rd = new Random();
	private static Util instance = new Util();
	private static Charset charSet = StandardCharsets.UTF_8;
	private static String filePath = "src/files";
	Util (){}

	public static int getValue(String msg, int start, int end) {
		while (true) {
			try {
				System.out.printf("▶ %s (%d-%d)입력: ", msg, start, end);
				int input = sc.nextInt();
				if (input < start || input > end) {
					System.out.println("입력 범위 오류입니다.");
					continue;
				}
				return input;
			} catch (InputMismatchException e) {
				System.out.println("숫자만 입력 가능합니다.");
				sc.nextLine();
			}

		}

	}

	public static String getValue(String msg) {
		System.out.printf("▶ %s  입력:",msg);
		return sc.next();
	}
	
	public static void printMenu() {
		Path path = Paths.get(filePath, "Title.txt");
		String data = "";
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path.toString()),charSet))){
			while(true) {
				data = br.readLine();
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (data == null)break;
				System.out.println(data);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}



}
