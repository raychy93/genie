import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.User;

import java.util.Objects;

public class TransferOwnership extends Command {


    public TransferOwnership()
    {

        this.name = "Coronation";
        this.aliases = new String[] {"king", "transfer"};
        this.help = "Ascension to the throne";



    }


    @Override
    protected void execute(CommandEvent event) {

        Role role = event.getGuild().getRoleById("820720334797668353");
        String[] message = event.getMessage().getContentRaw().split(" ");
        if (message.length == 1 && message[0].equalsIgnoreCase("$coronation")) {
            event.getChannel().sendMessage("Help ascend someone to the Chosen Role, type $coronation [name]").queue();
        } else if (message.length >= 2 && message[0].equalsIgnoreCase("$coronation")) {
            String userName = message[1];
            //User use = event.getAuthor();

            User user = event.getGuild().getMembersByName(userName, true).get(0).getUser();
            if(Objects.requireNonNull(event.getMessage().getMember()).hasPermission(Permission.MANAGE_ROLES))
            {
               Objects.requireNonNull(event.getGuild().getMember(user)).getRoles().add(role);
            }

        }
    }
}
