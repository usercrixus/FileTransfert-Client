package supra.client.command.effective;

import supra.client.command.Command;
import supra.client.entity.Session;

public class CDCommand extends Command {
	public CDCommand(String[] args) {
		if(args.length == 2) {
			String response = send(cd(args));
			if(response.compareTo("false") == 0) {
				System.out.println(args[1]+" isnt a directory path");
			}else if(response.compareTo("") != 0) {
				Session.path = response;
			}
		}else {
		    System.out.println(badUsage());
		}
	}
	
	public String cd(String[] args) {
		StringBuilder command = new StringBuilder();
		
		command.append(args[0]);
		command.append(" ");
		command.append(Session.path+"/"+args[1]);
				
		return command.toString();
	}

	@Override
	public String badUsage() {
		return "Usage : cd path";
	}
}
