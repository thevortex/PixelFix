package Pixelfix.asm;

import java.util.Iterator;
import java.util.logging.Level;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.relauncher.FMLRelaunchLog;
import net.minecraft.launchwrapper.IClassTransformer;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.*;

public class PixelfixClassTransformer implements IClassTransformer
{
	public FMLLog log = new FMLLog();
	
    @Override
    public byte[] transform(String name, String name2, byte[] bytes)
    {
    	if("pixelmon.tools.List".equals(name))
        {
        	log.info("Pixelfix: Located Pixelmon...", new Object[0]);
        	
            ClassReader cr = new ClassReader(bytes);
            ClassNode cn = new ClassNode(Opcodes.ASM4);
            cr.accept(cn, ClassReader.EXPAND_FRAMES);
            
            for(Object mno : cn.methods)
            {
                MethodNode mn = (MethodNode)mno;

                if("check".equals(mn.name) && "()V".equals(mn.desc))
                {
                	log.info("Pixelfix: Located DRM...", new Object[0]);
                	mn.localVariables.clear();
                	mn.tryCatchBlocks.clear();
                    mn.instructions.clear();
                    mn.instructions.add(new InsnNode((Opcodes.RETURN)));
                    mn.maxLocals = 0;
                    mn.maxStack = 0;
                }
                if("getNames".equals(mn.name) && "()V".equals(mn.desc))
                {
                	log.info("Pixelfix: Located DRM 2...", new Object[0]);
                	mn.localVariables.clear();
                	mn.tryCatchBlocks.clear();
                    mn.instructions.clear();
                    mn.instructions.add(new InsnNode((Opcodes.RETURN)));
                    mn.maxLocals = 0;
                    mn.maxStack = 0;
                }
            }

            ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES | ClassWriter.COMPUTE_MAXS);
            cn.accept(cw);
            
            return cw.toByteArray();
        }

        return bytes;
    }

	
}
