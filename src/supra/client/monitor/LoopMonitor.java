package supra.client.monitor;

import java.util.Scanner;

import supra.client.command.CommandRouter;
import supra.client.entity.Command;
import supra.client.entity.Session;

public class LoopMonitor {
	
	public LoopMonitor() {
		launch();
	}
	
	public static void launch() {
		boolean exit = false;
		Scanner scanner = new Scanner(System.in);
		while(!exit) {
			System.out.print(Session.path+": ");
			String bufferCommand = scanner.nextLine();
			String[] args = bufferCommand.split(" ");
			args[0] = args[0].toUpperCase(); // The command is always upper case
			Command command;
			
			try {
				command = Command.valueOf(args[0]);				
			}catch (Exception e) {
				command = Command.ERROR;
			}
			
			if(command == Command.EXIT) {
				exit = true;
			}else if(command == Command.ERROR) {
				System.out.println("Unknow command");
			}else {
				new CommandRouter(command, args);
			}
		}
		scanner.close();
	}
}
