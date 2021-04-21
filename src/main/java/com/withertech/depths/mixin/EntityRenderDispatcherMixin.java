package com.withertech.depths.mixin;

import com.withertech.depths.entities.SoulBlazeEntity;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.model.ModelLoader;
import net.minecraft.client.texture.Sprite;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.util.math.Vector3f;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(net.minecraft.client.render.entity.EntityRenderDispatcher.class)
public class EntityRenderDispatcherMixin
{
	@Shadow
	public Camera camera;

	@Shadow
	private static void drawFireVertex(MatrixStack.Entry entry, VertexConsumer vertices, float x, float y, float z, float u, float v) {}

	@Inject(method = "renderFire", at = @At(value = "HEAD", target = "Lnet/minecraft/client/render/entity/EntityRenderDispatcher;renderFire(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;Lnet/minecraft/entity/Entity;)V"), cancellable = true)
	private void renderFire(MatrixStack matrices, VertexConsumerProvider vertexConsumers, Entity entity, CallbackInfo ci)
	{
		if (entity instanceof SoulBlazeEntity)
		{
			renderSoulFire(matrices, vertexConsumers, entity);
			ci.cancel();
		}
	}

	private void renderSoulFire(MatrixStack matrices, VertexConsumerProvider vertexConsumers, Entity entity)
	{
		Sprite sprite = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier("block/soul_fire_0")).getSprite();
		Sprite sprite2 = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier("block/soul_fire_1")).getSprite();
		matrices.push();
		float f = entity.getWidth() * 1.4F;
		matrices.scale(f, f, f);
		float g = 0.5F;
		float h = 0.0F;
		float i = entity.getHeight() / f;
		float j = 0.0F;
		matrices.multiply(Vector3f.POSITIVE_Y.getDegreesQuaternion(-this.camera.getYaw()));
		matrices.translate(0.0D, 0.0D, (double)(-0.3F + (float)((int)i) * 0.02F));
		float k = 0.0F;
		int l = 0;
		VertexConsumer vertexConsumer = vertexConsumers.getBuffer(TexturedRenderLayers.getEntityCutout());

		for(MatrixStack.Entry entry = matrices.peek(); i > 0.0F; ++l) {
			Sprite sprite3 = l % 2 == 0 ? sprite : sprite2;
			float m = sprite3.getMinU();
			float n = sprite3.getMinV();
			float o = sprite3.getMaxU();
			float p = sprite3.getMaxV();
			if (l / 2 % 2 == 0) {
				float q = o;
				o = m;
				m = q;
			}

			drawFireVertex(entry, vertexConsumer, g - 0.0F, 0.0F - j, k, o, p);
			drawFireVertex(entry, vertexConsumer, -g - 0.0F, 0.0F - j, k, m, p);
			drawFireVertex(entry, vertexConsumer, -g - 0.0F, 1.4F - j, k, m, n);
			drawFireVertex(entry, vertexConsumer, g - 0.0F, 1.4F - j, k, o, n);
			i -= 0.45F;
			j -= 0.45F;
			g *= 0.9F;
			k += 0.03F;
		}

		matrices.pop();
	}
}
