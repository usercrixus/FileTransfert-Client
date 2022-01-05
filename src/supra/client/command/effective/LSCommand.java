package supra.client.command.effective;

import supra.client.command.Command;
import supra.client.entity.Session;

public class LSCommand extends Command {
	public LSCommand(String[] args) {
		if(args.length <= 2) {
			String response = send(ls(args));
			if(response.compareTo("") != 0)	System.out.println(response);

		}else {
		    System.out.println(badUsage());
		}
	}
	
	public String ls(String[] args) {
		StringBuilder command = new StringBuilder();
		
		command.append(args[0]);
		command.append(" ");
		command.append(Session.path+"/");
		if(args.length == 2 ) {
			command.append(args[1]);
		}
		
		return command.toString();
	}

	@Override
	public String badUsage() {
		return "Usage : ls [path]";
	}
	
	
}
