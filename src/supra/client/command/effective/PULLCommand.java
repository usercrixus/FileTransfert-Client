package supra.client.command.effective;

import supra.client.command.Command;
import supra.client.entity.Session;

public class PULLCommand  extends Command  {
	public PULLCommand(String[] args) {
		if(args.length == 2) {
			System.out.println( requestFile(pull(args), defineFileName(args[1])) );
		}else {
			System.out.println(badUsage());
		}
	}
	
	public String pull(String[] args) {
		StringBuilder command = new StringBuilder();
		
		command.append(args[0]);
		command.append(" ");
		command.append(Session.path+"/");
		command.append(args[1]);
		
		return command.toString();
	}
	
	public String defineFileName(String args) {
		String[] path = args.split("/");
		return path[path.length-1];
	}

	@Override
	public String badUsage() {
		return "Usage : pull [path]";
	}
}
