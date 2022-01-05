package supra.client.command;

import supra.client.command.effective.CDCommand;
import supra.client.command.effective.LSCommand;
import supra.client.command.effective.PULLCommand;
import supra.client.entity.Command;

public class CommandRouter {
	
	public CommandRouter(Command command, String[] args) {
		
		switch (command) {
		case LS :  {
			new LSCommand(args);
			break;
		}
		case CD : {
			new CDCommand(args);
			break;
		}
		case PULL : {
			new PULLCommand(args);
			break;
		}
		case PUSH : {
			
			break;
		}
		default:

		}
	}


}
