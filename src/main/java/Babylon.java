import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Icon;
import net.dv8tion.jda.api.entities.Member;

import java.io.File;
import java.io.IOException;

public class Babylon extends Command {


    public Babylon(){


        this.name = "babylon";
        this.aliases = new String[] {"akkad, sumer"};
        this.help = "Erupt the gardens of Babylon ";


    }

    @Override
    protected void execute(CommandEvent event) {
        File file = new File("[insert file path]");
        try {

            event.getGuild().getManager().setIcon(Icon.from(file)).queue();
        } catch (IOException e) {
            e.printStackTrace();
        }
        event.getGuild().getManager().setName("Neo Babylon: " + "\uD808\uDD8D\uD808\uDC2D\uD808\uDE8F\uD808\uDDA0").queue();
        event.getGuild().getTextChannelById("842238760216821770").getManager().setName("\uD808\uDD8D\uD808\uDC2D\uD808\uDE8F\uD808\uDDA0").queue();
        event.getGuild().getTextChannelById("842239434245144617").getManager().setName("\uD808\uDD8D\uD808\uDC2D\uD808\uDE8F\uD808\uDDA0").queue();
        event.getGuild().getTextChannelById("842265107815202816").getManager().setName("\uD808\uDD8D\uD808\uDC2D\uD808\uDE8F\uD808\uDDA0").queue();
        event.getGuild().getTextChannelById("842239479820582912").getManager().setName("\uD808\uDD8D\uD808\uDC2D\uD808\uDE8F\uD808\uDDA0").queue();
        event.getGuild().getTextChannelById("842247403428118558").getManager().setName("\uD808\uDD8D\uD808\uDC2D\uD808\uDE8F\uD808\uDDA0").queue();
        event.getGuild().getTextChannelById("842239651031941120").getManager().setName("\uD808\uDD8D\uD808\uDC2D\uD808\uDE8F\uD808\uDDA0").queue();
        event.getGuild().getTextChannelById("842265472073728041").getManager().setName("\uD808\uDD8D\uD808\uDC2D\uD808\uDE8F\uD808\uDDA0").queue();
        event.getGuild().getTextChannelById("842239622976765952").getManager().setName("\uD808\uDD8D\uD808\uDC2D\uD808\uDE8F\uD808\uDDA0").queue();
        event.getGuild().getTextChannelById("842239603402211368").getManager().setName("\uD808\uDD8D\uD808\uDC2D\uD808\uDE8F\uD808\uDDA0").queue();
        event.getGuild().getTextChannelById("842247417893879809").getManager().setName("\uD808\uDD8D\uD808\uDC2D\uD808\uDE8F\uD808\uDDA0").queue();
        event.getGuild().getTextChannelById("842240668491317269").getManager().setName("\uD808\uDD8D\uD808\uDC2D\uD808\uDE8F\uD808\uDDA0").queue();
        event.getGuild().getTextChannelById("842239571429425172").getManager().setName("\uD808\uDD8D\uD808\uDC2D\uD808\uDE8F\uD808\uDDA0").queue();
        event.getGuild().getTextChannelById("842239521227931659").getManager().setName("\uD808\uDD8D\uD808\uDC2D\uD808\uDE8F\uD808\uDDA0").queue();
        event.getGuild().getTextChannelById("842248572229255220").getManager().setName("\uD808\uDD8D\uD808\uDC2D\uD808\uDE8F\uD808\uDDA0").queue();
        event.getGuild().getTextChannelById("842248881776623656").getManager().setName("\uD808\uDD8D\uD808\uDC2D\uD808\uDE8F\uD808\uDDA0").queue();
        event.getGuild().getTextChannelById("842249881342312458").getManager().setName("\uD808\uDD8D\uD808\uDC2D\uD808\uDE8F\uD808\uDDA0").queue();
        event.getGuild().getTextChannelById("842251090116476928").getManager().setName("\uD808\uDD8D\uD808\uDC2D\uD808\uDE8F\uD808\uDDA0").queue();
        //event.getGuild().getTextChannelById("834876084734263316").getManager().setName("\uD808\uDD8D\uD808\uDC2D\uD808\uDE8F\uD808\uDDA0").queue();
        event.getGuild().getVoiceChannelById("842239758196801542").getManager().setName("\uD808\uDD8D\uD808\uDC2D\uD808\uDE8F\uD808\uDDA0").queue();
        event.getGuild().getVoiceChannelById("842239726001586196").getManager().setName("\uD808\uDD8D\uD808\uDC2D\uD808\uDE8F\uD808\uDDA0").queue();
        //event.getGuild().getVoiceChannelById("828753097936732240").getManager().setName("\uD808\uDD8D\uD808\uDC2D\uD808\uDE8F\uD808\uDDA0").queue();
        event.getGuild().getCategoryById("842239837213425694").getManager().setName("\uD808\uDD8D\uD808\uDC2D\uD808\uDE8F\uD808\uDDA0").queue();
        event.getGuild().getCategoryById("842239993098534932").getManager().setName("\uD808\uDD8D\uD808\uDC2D\uD808\uDE8F\uD808\uDDA0").queue();
        event.getGuild().getCategoryById("842246179244343306").getManager().setName("\uD808\uDD8D\uD808\uDC2D\uD808\uDE8F\uD808\uDDA0").queue();
        event.getGuild().getCategoryById("842242232857264138").getManager().setName("\uD808\uDD8D\uD808\uDC2D\uD808\uDE8F\uD808\uDDA0").queue();
        event.getGuild().getCategoryById("842245655804379147").getManager().setName("\uD808\uDD8D\uD808\uDC2D\uD808\uDE8F\uD808\uDDA0").queue();
        event.getGuild().getCategoryById("842240363162370078").getManager().setName("\uD808\uDD8D\uD808\uDC2D\uD808\uDE8F\uD808\uDDA0").queue();
        event.getGuild().getCategoryById("842249424080338995").getManager().setName("\uD808\uDD8D\uD808\uDC2D\uD808\uDE8F\uD808\uDDA0").queue();
        //event.getGuild().getCategoryById("828753179008041000").getManager().setName("\uD808\uDD8D\uD808\uDC2D\uD808\uDE8F\uD808\uDDA0").queue();





    }



//







}
